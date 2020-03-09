package problem_0055_JumpGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {
    private JumpGame solution;
    private int[] nums;
    private boolean expected;

    @Before
    public void setUp() {
        solution = new JumpGame();
        nums = new int[]{2, 3, 1, 1, 4};
        expected = true;
    }

    @Test
    public void testCanJump1() {
        boolean result = solution.canJump1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testCanJump2() {
        boolean result = solution.canJump2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testCanJump3() {
        boolean result = solution.canJump3(nums);
        assertEquals(expected, result);
    }
    @Test
    public void testCanJump4() {
        boolean result = solution.canJump4(nums);
        assertEquals(expected, result);
    }

}