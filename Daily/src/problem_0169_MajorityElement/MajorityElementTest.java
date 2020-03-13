package problem_0169_MajorityElement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {
    MajorityElement solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new MajorityElement();
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        expected = 2;
    }

    @Test
    public void testMajorityElement1() {
        int result = solution.majorityElement1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMajorityElement2() {
        int result = solution.majorityElement2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMajorityElement3() {
        int result = solution.majorityElement3(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMajorityElement4() {
        int result = solution.majorityElement4(nums);
        assertEquals(expected, result);
    }
}