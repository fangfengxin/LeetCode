package problem_0136_SingleNumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {
    SingleNumber solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new SingleNumber();
        nums = new int[]{4, 1, 2, 1, 2};
        expected = 4;
    }

    @Test
    public void testSingleNumber1() {
        int result = solution.singleNumber1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleNumber2() {
        int result = solution.singleNumber2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleNumber3() {
        int result = solution.singleNumber3(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleNumber4() {
        int result = solution.singleNumber4(nums);
        assertEquals(expected, result);
    }
}