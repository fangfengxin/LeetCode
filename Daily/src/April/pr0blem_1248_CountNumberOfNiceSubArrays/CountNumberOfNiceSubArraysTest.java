package April.pr0blem_1248_CountNumberOfNiceSubArrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 11:45
 */
class CountNumberOfNiceSubArraysTest {
    private CountNumberOfNiceSubArrays solution;
    private int[] nums;
    private int k;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new CountNumberOfNiceSubArrays();
        nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        k = 2;
        expected = 16;
    }

    @Test
    void numberOfSubArrays1() {
        int result = solution.numberOfSubArrays1(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void numberOfSubArrays2() {
        int result = solution.numberOfSubArrays2(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void numberOfSubArrays3() {
        int result = solution.numberOfSubArrays3(nums, k);
        assertEquals(expected, result);
    }
}