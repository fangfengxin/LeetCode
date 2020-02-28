package problem_011_ContainerWithMostWater;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem_011_ContainerWithMostWater.ContainerWithMostWater;

public class ContainerWithMostWaterTest {
    private ContainerWithMostWater solution;
    private int[] height;
    private int expected;

    @Before
    public void init() {
        solution = new ContainerWithMostWater();
        height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        expected = 49;
    }

    @Test
    public void testMaxArea1() {
        int result = solution.maxArea1(height);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMaxArea2() {
        int result = solution.maxArea2(height);
        Assert.assertEquals(expected, result);
    }
}
