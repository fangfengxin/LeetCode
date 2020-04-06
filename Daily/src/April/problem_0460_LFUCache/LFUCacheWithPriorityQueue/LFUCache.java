package April.problem_0460_LFUCache.LFUCacheWithPriorityQueue;

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

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 使用最小堆实现 LFU
 * Java 中 PriorityQueue 默认是最小堆
 * 时间复杂度 O(log N)
 */
public class LFUCache {
    // 存储缓存的内容
    private Map<Integer, Node> cache;
    // 优先队列（最小堆），快速找到 minFreq
    private Queue<Node> queue;
    private int capacity;
    private int size;
    private int index;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        if (capacity > 0) {
            queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
        size = 0;
        index = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        node.index = index++;
        queue.remove(node);
        queue.offer(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.freq++;
            node.index = index++;
            queue.remove(node);
            queue.offer(node);
        } else {
            if (size == capacity) {
                Node deadNode = queue.poll();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value, index++);
            cache.put(key, newNode);
            queue.offer(newNode);
            size++;
        }
    }
}
