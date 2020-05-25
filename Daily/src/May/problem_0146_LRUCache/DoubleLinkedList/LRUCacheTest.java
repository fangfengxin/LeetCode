package May.problem_0146_LRUCache.DoubleLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author hustffx
 */
public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}