package April.problem_0460_LFUCache.LFUCacheUsingDoublyLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LFUCacheTest {
    @Test
    public void test() {
        LFUCache cache = new LFUCache(2);
        /*cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(cache.get(1), 1);
        // 去除 key 2
        cache.put(3, 3);
        assertEquals(cache.get(2), -1);
        assertEquals(cache.get(3), 3);       // 返回 3
        // 去除 key 1
        cache.put(4, 4);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(3), 3);
        assertEquals(cache.get(4), 4);*/

        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        assertEquals(cache.get(2), 2);
    }
}