package problem_001_TwoSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

    private TwoSum solution;
    private int[] nums;
    private int target;
    private int[] expected;
    private long startTime;

    @Before
    public void init() {
        startTime = System.currentTimeMillis();
        solution = new TwoSum();
        nums = new int[]{0, 1, 2, 4, 6, 7, 11, 15};
        target = 9;
        expected = new int[]{2, 5};
    }

    @Test
    public void testTwoSum1() {
        int[] result = solution.twoSum1(nums, target);
        Assert.assertArrayEquals(expected, result);
        System.out.println("执行用时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testTwoSum2() {
        int[] result = solution.twoSum2(nums, target);
        Assert.assertArrayEquals(expected, result);
        System.out.println("执行用时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void testTwoSum3() {
        int[] result = solution.twoSum3(nums, target);
        Assert.assertArrayEquals(expected, result);
        System.out.println("执行用时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
