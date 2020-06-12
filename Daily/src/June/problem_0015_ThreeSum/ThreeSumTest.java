package June.problem_0015_ThreeSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/12 10:48
 */
class ThreeSumTest {
    private ThreeSum solution;
    private int[] nums;
    private List<List<Integer>> expected;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
    }

    @Test
    void threeSum() {
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }
}