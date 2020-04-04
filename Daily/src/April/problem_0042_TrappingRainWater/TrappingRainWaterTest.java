package April.problem_0042_TrappingRainWater;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrappingRainWaterTest {
    TrappingRainWater solution;
    int[] height;
    int expected;

    @Before
    public void setUp() {
        solution = new TrappingRainWater();
        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        expected = 6;
    }

    @Test
    public void testTrap1() {
        int result = solution.trap1(height);
        assertEquals(expected, result);
    }

    @Test
    public void testTrap2() {
        int result = solution.trap2(height);
        assertEquals(expected, result);
    }

    @Test
    public void testTrap3() {
        int result = solution.trap3(height);
        assertEquals(expected, result);
    }
}