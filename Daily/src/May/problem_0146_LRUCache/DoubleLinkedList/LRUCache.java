package May.problem_0146_LRUCache.DoubleLinkedList;

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
 * 使用哈希表实现快速存取
 * 使用双向链表实现快速删除最久未使用的节点
 *
 * @Author hustffx
 * @Date 2020/5/25 21:46
 */
public class LRUCache {
    /**
     * 缓存区，使用哈希表存储key和节点的对应关系
     */
    private final HashMap<Integer, DLinkedNode> cache;
    /**
     * 使用双向链表记录最久未使用的节点
     */
    private final DLinkedList list;
    /**
     * 缓存区的容量
     */
    private final int capacity;
    /**
     * 实际存储的数据量
     */
    private int size;

    /**
     * 构造方法，初始化LRUCache
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        list = new DLinkedList();
        this.capacity = capacity;
        size = 0;
    }

    /**
     * 获取数据。
     * 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        list.move(node);
        return node.value;
    }

    /**
     * 写入数据。
     * 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            while (size >= capacity) {
                DLinkedNode pop = list.pop();
                cache.remove(pop.key);
                size--;
            }
            cache.put(key, node);
            list.add(node);
            size++;
        } else {
            node.value = value;
            list.move(node);
        }
    }

    /**
     * 实现双向链表节点
     */
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 实现双向链表
     * 最近访问的节点存储在链表头部
     */
    private class DLinkedList {
        DLinkedNode head;
        DLinkedNode tail;

        public DLinkedList() {
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        /**
         * 向链表头部添加节点
         *
         * @param node
         */
        public void add(DLinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        /**
         * 删除链表中的节点
         *
         * @param node
         */
        public void remove(DLinkedNode node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        /**
         * 将节点移到链表头部
         *
         * @param node
         */
        public void move(DLinkedNode node) {
            remove(node);
            add(node);
        }

        /**
         * 将链表尾部节点删除
         *
         * @return
         */
        public DLinkedNode pop() {
            DLinkedNode toBeDeleted = tail.pre;
            remove(toBeDeleted);
            return toBeDeleted;
        }
    }
}
