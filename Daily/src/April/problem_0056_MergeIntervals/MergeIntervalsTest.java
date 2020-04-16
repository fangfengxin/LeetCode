package April.problem_0056_MergeIntervals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {
    private MergeIntervals solution;
    private int[][] intervals;
    private int[][] expected;

    @Before
    public void setUp() {
        solution = new MergeIntervals();
        intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
    }

    @Test
    public void testMerge() {
        int[][] result = solution.merge(intervals);
        assertArrayEquals(expected, result);
    }
}