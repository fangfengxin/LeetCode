package June.problem_0016_ThreeSumClosest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/24 15:45
 */
class ThreeSumClosestTest {
    private ThreeSumClosest solution;
    private int[] nums;
    private int target;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new ThreeSumClosest();
        nums = new int[]{-1, 2, 1, -4};
        target = 1;
        expected = 2;
    }

    @Test
    void threeSumClosest() {
        int result = solution.threeSumClosest(nums, target);
        assertEquals(expected, result);
    }
}