package problem_1013_PartitionArrayIntoThreePartsWithEqualSum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionArrayIntoThreePartsWithEqualSumTest {
    PartitionArrayIntoThreePartsWithEqualSum solution;
    int[] A;
    boolean expected;

    @Before
    public void setUp() {
        solution = new PartitionArrayIntoThreePartsWithEqualSum();
        A = new int[]{1, -1, 1, -1};
        expected = false;
    }

    @Test
    public void canThreePartsEqualSum1() {
        boolean result = solution.canThreePartsEqualSum1(A);
        assertEquals(expected, result);
    }

    @Test
    public void canThreePartsEqualSum2() {
        boolean result = solution.canThreePartsEqualSum2(A);
        assertEquals(expected, result);
    }
}