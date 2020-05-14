package May.problem_0136_SingleNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/14 11:04
 */
class SingleNumberTest {
    private SingleNumber solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SingleNumber();
        nums = new int[]{4, 1, 2, 1, 2};
        expected = 4;
    }

    @Test
    void singleNumber1() {
        int result = solution.singleNumber1(nums);
        assertEquals(expected, result);
    }

    @Test
    void singleNumber2() {
        int result = solution.singleNumber2(nums);
        assertEquals(expected, result);
    }
}