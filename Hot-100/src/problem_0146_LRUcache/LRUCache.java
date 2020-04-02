package problem_0146_LRUcache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用有序字典实现 LRU
 * Java 提供了 LinkedHashMap
 * HashMap 底层是 数组 + 红黑树 + 链表，同时其是无序的，而 LinkedHashMap 提供 有序。
 * LinkedHashMap的有序可以按两种顺序排列：
 *   1.一种是按照插入的顺序
 *   2.一种是按照读取的顺序（这个题目的示例就是告诉我们要按照读取的顺序进行排序），
 * 而其内部是靠 建立一个双向链表 来维护这个顺序的，在每次插入、删除后，都会调用一个函数来进行 双向链表的维护 。
 * 准确的来说，是有三个函数来做这件事，这三个函数都统称为 回调函数 ，这三个函数分别是：
 *   1. void afterNodeAccess(Node<K,V> p) { }
 *      在访问元素之后，将该元素放到双向链表的尾巴处。
 *   2. void afterNodeRemoval(Node<K,V> p) { }
 *      在删除元素之后，将元素从双向链表中删除。
 *   3. void afterNodeInsertion(boolean evict) { }
 *      在插入新元素之后，判断是否需要移除一直不用的某些元素。
 * 再介绍一下 LinkedHashMap 的构造函数：
 *   1. 调用 HashMap 的构造方法
 *   2. 可以选择 accessOrder 的值来确定是按插入顺序还是读取顺序排序。
 *      默认 false，代表按照插入顺序排序。
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        // 将 LinkedHashMap 的 accessOrder 修改为 true，表示按照读取顺序排序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 默认情况下不删除久未使用的元素，需要重写判断条件
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
