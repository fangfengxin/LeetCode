package problem_0945_MinimumIncrementToMakeArrayUnique;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumIncrementToMakeArrayUniqueTest {
    MinimumIncrementToMakeArrayUnique solution;
    int[] A;
    int expected;

    @Before
    public void setUp() {
        solution = new MinimumIncrementToMakeArrayUnique();
        A = new int[]{3, 2, 1, 2, 1, 7};
        expected = 6;
    }

    @Test
    public void testMinIncrementForUnique1() {
        int result = solution.minIncrementForUnique1(A);
        assertEquals(expected, result);
    }

    @Test
    public void testMinIncrementForUnique2() {
        int result = solution.minIncrementForUnique2(A);
        assertEquals(expected, result);
    }

}