package problem_015_ThreeSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {
    private ThreeSum solution;
    private int[] nums;
    private List<List<Integer>> expected;

    @Before
    public void init() {
        solution = new ThreeSum();
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        //nums = new int[]{-1, 0, 1, 2, -1, -4};
        //expected = List.of(List.of(-1, 0, 1), List.of(-1, -1, 2));
        //nums = new int[]{0,0,0};
        //expected = List.of(List.of(0,0,0));
    }

    @Test
    public void testThreeSum1() {
        List<List<Integer>> result = solution.threeSum1(nums);
        Assert.assertEquals(expected, result);
    }

    /*@Test
    public void testThreeSum2() {
        List<List<Integer>> result = solution.threeSum2(nums);
        Assert.assertEquals(expected, result);
    }*/

    @Test
    public void testThreeSum3() {
        List<List<Integer>> result = solution.threeSum3(nums);
        Assert.assertEquals(expected, result);
    }
}
