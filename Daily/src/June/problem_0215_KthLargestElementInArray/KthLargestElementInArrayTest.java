package June.problem_0215_KthLargestElementInArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/29 12:36
 */
class KthLargestElementInArrayTest {
    private KthLargestElementInArray solution;
    private int[] nums;
    private int k;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new KthLargestElementInArray();
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        expected = 4;
    }

    @Test
    void findKthLargest1() {
        int result = solution.findKthLargest1(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void findKthLargest2() {
        int result = solution.findKthLargest2(nums, k);
        assertEquals(expected, result);
    }
}