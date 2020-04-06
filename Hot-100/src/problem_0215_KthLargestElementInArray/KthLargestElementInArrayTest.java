package problem_0215_KthLargestElementInArray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestElementInArrayTest {
    KthLargestElementInArray solution;
    int[] nums;
    int k;
    int expected;

    @Before
    public void setUp() {
        solution = new KthLargestElementInArray();
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        expected = 4;
    }

    @Test
    public void testFindKthLargest1() {
        int result = solution.findKthLargest1(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testFindKthLargest2() {
        int result = solution.findKthLargest2(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testFindKthLargest3() {
        int result = solution.findKthLargest3(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testFindKthLargest4() {
        int result = solution.findKthLargest4(nums, k);
        assertEquals(expected, result);
    }
}