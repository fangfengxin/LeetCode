package May.problem_0146_LRUCache.LinkedHashMap;

/*
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 1. 获取数据 get(key)
 *    如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 2. 写入数据 put(key, value)
 *    如果密钥不存在，则写入其数据值。
 *    当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用有序字典实现 LRU
 * Java 提供了 LinkedHashMap
 * HashMap 底层是 数组 + 红黑树 + 链表，同时其是无序的，而 LinkedHashMap 提供 有序。
 * LinkedHashMap的有序可以按两种顺序排列：
 * 1.一种是按照插入的顺序
 * 2.一种是按照读取的顺序（这个题目的示例就是告诉我们要按照读取的顺序进行排序），
 * 而其内部是靠 建立一个双向链表 来维护这个顺序的，在每次插入、删除后，都会调用一个函数来进行 双向链表的维护 。
 * 准确的来说，是有三个函数来做这件事，这三个函数都统称为 回调函数 ，这三个函数分别是：
 * 1. void afterNodeAccess(Node<K,V> p) { }
 * 在访问元素之后，将该元素放到双向链表的尾巴处。
 * 2. void afterNodeRemoval(Node<K,V> p) { }
 * 在删除元素之后，将元素从双向链表中删除。
 * 3. void afterNodeInsertion(boolean evict) { }
 * 在插入新元素之后，判断是否需要移除一直不用的某些元素。
 * 再介绍一下 LinkedHashMap 的构造函数：
 * 1. 调用 HashMap 的构造方法
 * 2. 可以选择 accessOrder 的值来确定是按插入顺序还是读取顺序排序。
 * 默认 false，代表按照插入顺序排序。
 *
 * @Author hustffx
 * @Date 2020/5/25 21:20
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
