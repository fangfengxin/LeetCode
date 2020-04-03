package problem_0198_HouseRobber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {
    HouseRobber solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new HouseRobber();
        nums = new int[]{2, 7, 9, 3, 1};
        expected = 12;
    }

    @Test
    public void testRob1() {
        int result = solution.rob1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testRob2() {
        int result = solution.rob2(nums);
        assertEquals(expected, result);
    }
}