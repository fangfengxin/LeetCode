package June.problem_0238_ProductOfArrayExceptSelf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/6/4 10:15
 */
class ProductOfArrayExceptSelfTest {
    private ProductOfArrayExceptSelf solution;
    private int[] nums;
    private int[] expected;

    @BeforeEach
    void setUp() {
        solution = new ProductOfArrayExceptSelf();
        nums = new int[]{1, 2, 3, 4};
        expected = new int[]{24, 12, 8, 6};
    }

    @Test
    void productExceptSelf() {
        int[] result = solution.productExceptSelf(nums);
        assertArrayEquals(expected, result);
    }
}