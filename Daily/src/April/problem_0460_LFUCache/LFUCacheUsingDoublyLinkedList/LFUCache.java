package April.problem_0460_LFUCache.LFUCacheUsingDoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 舍弃存储频次的 HashMap，仅使用 DoublyLinkedList 实现 LFU
 */
public class LFUCache {
    // 存储缓存的内容
    private Map<Integer, Node> cache;
    // firstLinkedList.next 是频次最大的双向链表
    private DoublyLinkedList firstLinkedList;
    // lastLinkedList.pre 是频次最小的双向链表，满了之后删除 lastLinkedList.pre.tail.pre 这个 Node 即为频次最小且访问最早的 Node
    private DoublyLinkedList lastLinkedList;
    private int size;
    private int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        firstLinkedList = new DoublyLinkedList();
        lastLinkedList = new DoublyLinkedList();
        firstLinkedList.next = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                DoublyLinkedList minFreqList = lastLinkedList.pre;
                Node deadNode = minFreqList.tail.pre;
                cache.remove(deadNode.key);
                minFreqList.remove(deadNode);
                size--;
                if (minFreqList.head.next == minFreqList.tail) {
                    removeList(minFreqList);
                }
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if (lastLinkedList.pre.freq != 1) {
                DoublyLinkedList newList = new DoublyLinkedList(1);
                newList.add(newNode);
                addList(lastLinkedList.pre, newList);
            } else {
                lastLinkedList.pre.add(newNode);
            }
            size++;
        }
    }

    /**
     * 增加节点的访问频次
     *
     * @param node
     */
    private void freqInc(Node node) {
        // 获取节点所在链表
        DoublyLinkedList curList = node.curList;
        // 获取节点所在链表的前驱链表
        DoublyLinkedList preList = curList.pre;
        // 从当前链表中移除节点
        curList.remove(node);
        // 链表为空时，删除链表
        if (curList.head.next == curList.tail) {
            removeList(curList);
        }
        // 节点访问频次增加
        node.freq++;
        // 将节点加入新链表，对应频次的链表不存在则创建
        if (preList.freq != node.freq) {
            DoublyLinkedList newList = new DoublyLinkedList(node.freq);
            newList.add(node);
            addList(preList, newList);
        } else {
            preList.add(node);
        }
    }

    /**
     * 添加链表
     *
     * @param preList
     * @param newList
     */
    private void addList(DoublyLinkedList preList, DoublyLinkedList newList) {
        newList.next = preList.next;
        preList.next.pre = newList;
        newList.pre = preList;
        preList.next = newList;
    }

    /**
     * 删除链表
     *
     * @param curList
     */
    private void removeList(DoublyLinkedList curList) {
        curList.pre.next = curList.next;
        curList.next.pre = curList.pre;
    }
}
