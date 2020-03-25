package problem_0096_UniqueBinarySearchTrees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueBinarySearchTreesTest {
    UniqueBinarySearchTrees solution;
    int n, expected;

    @Before
    public void setUp() {
        solution = new UniqueBinarySearchTrees();
        n = 3;
        expected = 5;
    }

    @Test
    public void testNumTrees() {
        int result = solution.numTrees(n);
        assertEquals(expected, result);
    }
}