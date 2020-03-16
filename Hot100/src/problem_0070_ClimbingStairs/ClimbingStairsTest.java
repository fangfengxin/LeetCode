package problem_0070_ClimbingStairs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {
    ClimbingStairs solution;
    int n;
    int expected;

    @Before
    public void setUp() {
        solution = new ClimbingStairs();
        n = 3;
        expected = 3;
    }

    @Test
    public void testClimbStairs1() {
        int result = solution.climbStairs1(n);
        assertEquals(expected, result);
    }

    @Test
    public void testClimbStairs2() {
        int result = solution.climbStairs2(n);
        assertEquals(expected, result);
    }
    @Test
    public void testClimbStairs3() {
        int result = solution.climbStairs3(n);
        assertEquals(expected, result);
    }

}