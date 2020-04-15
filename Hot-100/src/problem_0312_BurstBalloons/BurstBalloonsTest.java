package problem_0312_BurstBalloons;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurstBalloonsTest {
    private BurstBalloons solution;
    private int[] nums;
    private int expected;

    @Before
    public void setUp() {
        solution = new BurstBalloons();
        nums = new int[]{3, 1, 5, 8};
        expected = 167;
    }

    @Test
    public void testMaxCoins1() {
        int result = solution.maxCoins1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxCoins2() {
        int result = solution.maxCoins2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxCoins3() {
        int result = solution.maxCoins3(nums);
        assertEquals(expected, result);
    }
}