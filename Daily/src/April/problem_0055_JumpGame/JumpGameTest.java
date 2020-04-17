package April.problem_0055_JumpGame;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author hustffx
 * @Date 2020/4/17 13:07
 */
class JumpGameTest {
    private JumpGame solution;
    private int[] nums;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        solution = new JumpGame();
        nums = new int[]{2, 3, 1, 1, 4};
    }

    @org.junit.jupiter.api.Test
    void canJump1() {
        boolean result = solution.canJump1(nums);
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void canJump2() {
        boolean result = solution.canJump2(nums);
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void canJump3() {
        boolean result = solution.canJump3(nums);
        assertTrue(result);
    }
}