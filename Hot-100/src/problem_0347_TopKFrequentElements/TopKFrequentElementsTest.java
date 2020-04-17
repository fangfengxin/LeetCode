package problem_0347_TopKFrequentElements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/17 14:01
 */
class TopKFrequentElementsTest {
    private TopKFrequentElements solution;
    private int[] nums;
    private int k;
    private List<Integer> expected;

    @BeforeEach
    void setUp() {
        solution = new TopKFrequentElements();
        nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        k = 2;
        expected = List.of(-1, 2);
    }

    @Test
    void topKFrequent1() {
        List<Integer> result = solution.topKFrequent1(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void topKFrequent2() {
        List<Integer> result = solution.topKFrequent2(nums, k);
        assertEquals(expected, result);
    }
}