package June.problem_1300_SumOfMutatedArrayClosestToTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/14 22:53
 */
class SumOfMutatedArrayClosestToTargetTest {
    private SumOfMutatedArrayClosestToTarget solution;
    private int[] arr;
    private int target;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SumOfMutatedArrayClosestToTarget();
        arr = new int[]{60864, 25176, 27249, 21296, 20204};
        target = 56803;
        expected = 11361;
    }

    @Test
    void findBestValue() {
        int result = solution.findBestValue(arr, target);
        assertEquals(expected, result);
    }
}