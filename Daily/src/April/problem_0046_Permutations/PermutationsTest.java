package April.problem_0046_Permutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/25 13:26
 */
class PermutationsTest {
    private Permutations solution;
    private int[] nums;
    private List<List<Integer>> expected;

    @BeforeEach
    void setUp() {
        solution = new Permutations();
        nums = new int[]{1, 2, 3};
        expected = Arrays.asList(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
    }

    @Test
    void permute() {
        List<List<Integer>> result = solution.permute(nums);
        assertEquals(expected, result);
    }
}