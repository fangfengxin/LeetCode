package May.problem_0146_LRUCache.LinkedHashMap;

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
        assertEquals(cache.get(1), 1);
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        assertEquals(cache.get(2), -1);
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(3), 3);
        assertEquals(cache.get(4), 4);
    }
}