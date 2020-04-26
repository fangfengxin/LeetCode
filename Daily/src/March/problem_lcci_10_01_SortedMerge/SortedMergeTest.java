package March.problem_lcci_10_01_SortedMerge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortedMergeTest {
    SortedMerge solution;
    int[] A, B, expected;
    int m, n;

    @Before
    public void setUp() {
        solution = new SortedMerge();
        A = new int[]{1, 2, 3, 0, 0, 0};
        m = 3;
        B = new int[]{2, 5, 6};
        n = 3;
        expected = new int[]{1, 2, 2, 3, 5, 6};
    }

    @Test
    public void testMerge1() {
        solution.merge1(A, m, B, n);
        assertArrayEquals(expected, A);
    }

    @Test
    public void testMerge2() {
        solution.merge2(A, m, B, n);
        assertArrayEquals(expected, A);
    }
}