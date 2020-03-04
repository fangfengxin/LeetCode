package problem_042_TrappingRainWater;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {
    private TrappingRainWater solution;
    private int[] height;
    private int expected;

    @Before
    public void init() {
        solution = new TrappingRainWater();
        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        expected = 6;
    }

    @Test
    public void testTrap1() {
        int result = solution.trap1(height);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTrap2() {
        int result = solution.trap2(height);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTrap3() {
        int result = solution.trap3(height);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTrap4() {
        int result = solution.trap4(height);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTrap5() {
        int result = solution.trap5(height);
        Assert.assertEquals(expected, result);
    }
}
