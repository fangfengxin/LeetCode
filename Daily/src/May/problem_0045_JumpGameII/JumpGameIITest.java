package May.problem_0045_JumpGameII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/4 17:15
 */
class JumpGameIITest {
    private JumpGameII solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new JumpGameII();
        nums = new int[]{2, 3, 1, 1, 4};
        expected = 2;
    }

    @Test
    void jump() {
        int result = solution.jump(nums);
        assertEquals(expected, result);
    }
}