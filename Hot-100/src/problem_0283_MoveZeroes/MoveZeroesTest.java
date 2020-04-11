package problem_0283_MoveZeroes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZeroesTest {
    private MoveZeroes solution;
    private int[] nums;
    private int[] expected;

    @Before
    public void setUp() {
        solution = new MoveZeroes();
        nums = new int[]{0, 1, 0, 3, 12};
        expected = new int[]{1, 3, 12, 0, 0};
    }

    @Test
    public void moveZeroes() {
        solution.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }
}