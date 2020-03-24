package problem_0075_SortColors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {
    SortColors solution;
    int[] nums;
    int[] expected;

    @Before
    public void setUp() {
        solution = new SortColors();
        nums = new int[]{2, 0, 2, 1, 1, 0};
        expected = new int[]{0, 0, 1, 1, 2, 2};
    }

    @Test
    public void testCortColors1() {
        solution.sortColors1(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testCortColors2() {
        solution.sortColors2(nums);
        assertArrayEquals(expected, nums);
    }
}