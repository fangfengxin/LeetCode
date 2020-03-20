package problem_interview_40_KSmallestNumbers;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KSmallestNumbersTest {
    KSmallestNumbers solution;
    int[] arr, expected;
    int k;

    @Before
    public void setUp() {
        solution = new KSmallestNumbers();
        arr = new int[]{3, 2, 1};
        k = 2;
        expected = new int[]{1, 2};
    }

    @Test
    public void testGetLeastNumbers1() {
        int[] result = solution.getLeastNumbers1(arr, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLeastNumbers2() {
        int[] result = solution.getLeastNumbers2(arr, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLeastNumbers3() {
        int[] result = solution.getLeastNumbers3(arr, k);
        Arrays.sort(result); // 因为是大根堆，所以排序，将数组变为升序，以保证比较正确
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLeastNumbers4() {
        int[] result = solution.getLeastNumbers4(arr, k);
        assertArrayEquals(expected, result);
    }
}