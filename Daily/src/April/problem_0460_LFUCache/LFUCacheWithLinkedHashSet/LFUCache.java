package April.problem_0460_LFUCache.LFUCacheWithLinkedHashSet;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
 * 460. LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *   1. get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 *   2. put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
 *                        在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * 一个项目的使用次数就是该项目被插入后对其调用 get 和 put 函数的次数之和。使用次数会在对应项目被移除后置为 0。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 * LFUCache cache = new LFUCache( 2 )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 */

/**
 * 使用 LinkedHashSet 实现 LFU
 * 时间复杂度 O(1)
 */
public class LFUCache {
    // 存储缓存的内容
    private Map<Integer, Node> cache;
    // 存储每个频次对应的双向链表
    private Map<Integer, LinkedHashSet<Node>> freqMap;
    private int capacity;
    private int size;
    // 存储当前最小频次
    private int minFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * 节点访问频次增加
     *
     * @param node
     */
    private void freqInc(Node node) {
        // 从原 freq 对应的链表中删除，并更新 minFreq
        LinkedHashSet<Node> curSet = freqMap.get(node.freq);
        curSet.remove(node);
        if (node.freq == minFreq && curSet.size() == 0) {
            minFreq = node.freq + 1;
        }
        // 加入新 freq 对应的链表
        node.freq++;
        freqMap.computeIfAbsent(node.freq, key -> new LinkedHashSet<>()).add(node);
    }

    /**
     * 添加新节点 node
     *
     * @param node
     */
    private void addNode(Node node) {
        freqMap.computeIfAbsent(1, key -> new LinkedHashSet<>()).add(node);
        // 新节点的频次为 1，更新最小频次
        minFreq = 1;
    }

    /**
     * 移除访问频次最小的节点中最近未使用的节点
     * 即最小频次对应的链表中的第一个节点
     */
    private Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }

    /**
     * 获取键 key 对应的值 value
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    /**
     * 向缓存中加入新的键 key 和值 value
     */
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            // 如果缓存中包含 key，则更新对应的 value，并增加节点频次
            Node node = cache.get(key);
            node.value = value;
            freqInc(node);
        } else {
            // 如果缓存已满，移除最少使用且最久未使用的节点（即最低频次的首节点）
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            // 向缓存中添加新节点，并将节点加入频次为 1 的链表
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }
}
