package problem_0338_CountingBits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountingBitsTest {
    private CountingBits solution;
    private int num;
    private int[] expected;

    @Before
    public void setUp() {
        solution = new CountingBits();
        num = 5;
        expected = new int[]{0, 1, 1, 2, 1, 2};
    }

    @Test
    public void testCountBits1() {
        int[] result = solution.countBits1(num);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCountBits2() {
        int[] result = solution.countBits2(num);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCountBits3() {
        int[] result = solution.countBits3(num);
        assertArrayEquals(expected, result);
    }
}