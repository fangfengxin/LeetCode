package problem_interview_17_16_TheMasseuse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheMasseuseTest {
    TheMasseuse solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new TheMasseuse();
        nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        expected = 12;
    }

    @Test
    public void testMassage1() {
        int result = solution.massage1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMassage2() {
        int result = solution.massage2(nums);
        assertEquals(expected, result);
    }
}