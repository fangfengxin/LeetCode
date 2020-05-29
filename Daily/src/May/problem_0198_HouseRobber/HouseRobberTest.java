package May.problem_0198_HouseRobber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/29 10:29
 */
class HouseRobberTest {
    private HouseRobber solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new HouseRobber();
        nums = new int[]{2, 7, 9, 3, 1};
        expected = 12;
    }

    @Test
    void rob() {
        int result = solution.rob(nums);
        assertEquals(expected, result);
    }
}