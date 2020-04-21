package problem_0581_ShortestUnsortedContinuousSubArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 16:29
 */
class ShortestUnsortedContinuousSubArrayTest {
    private ShortestUnsortedContinuousSubArray solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new ShortestUnsortedContinuousSubArray();
        nums = new int[]{2, 3, 3, 2, 4};
        expected = 3;
    }

    @Test
    void findUnsortedSubArray1() {
        int result = solution.findUnsortedSubArray1(nums);
        assertEquals(expected, result);
    }

    @Test
    void findUnsortedSubArray2() {
        int result = solution.findUnsortedSubArray2(nums);
        assertEquals(expected, result);
    }

    @Test
    void findUnsortedSubArray3() {
        int result = solution.findUnsortedSubArray3(nums);
        assertEquals(expected, result);
    }

    @Test
    void findUnsortedSubArray4() {
        int result = solution.findUnsortedSubArray4(nums);
        assertEquals(expected, result);
    }
}