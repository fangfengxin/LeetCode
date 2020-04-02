package problem_0146_LRUcache;

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

import java.util.HashMap;

/**
 * 使用哈希表和双向链表实现 LRU
 */
public class LRUCacheWithHashMapAndDoublyLinkedList {
    private int capacity;
    private int size;
    private HashMap<Integer, DoublyLinkedListNode> cache;
    private DoublyLinkedList list;

    /**
     * 构造方法
     *
     * @param capacity 缓存容量
     */
    public LRUCacheWithHashMapAndDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        list = new DoublyLinkedList();
    }


    /**
     * 获取数据
     *
     * @param key
     */
    public int get(int key) {
        DoublyLinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        list.moveToHead(node);
        return node.value;
    }

    /**
     * 写入数据
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            // 内存不够则移除链表尾部节点
            if (size >= capacity) {
                DoublyLinkedListNode last = list.popTail();
                cache.remove(last.key);
                size--;
            }
            // 新节点写入内存
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
            cache.put(key, newNode);
            list.add(newNode);
            size++;
        } else {
            // 更新节点值
            DoublyLinkedListNode node = cache.get(key);
            node.value = value;
            // 将节点移到链表头部
            list.moveToHead(node);
        }
    }
}
