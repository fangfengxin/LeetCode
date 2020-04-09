package problem_0238_ProductOfArrayExceptSelf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {
    private ProductOfArrayExceptSelf solution;
    private int[] nums;
    private int[] expected;

    @Before
    public void setUp() {
        solution = new ProductOfArrayExceptSelf();
        nums = new int[]{1, 2, 3, 4};
        expected = new int[]{24, 12, 8, 6};
    }

    @Test
    public void productExceptSelf() {
        int[] result = solution.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }
}