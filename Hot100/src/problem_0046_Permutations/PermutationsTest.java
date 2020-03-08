package problem_0046_Permutations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PermutationsTest {
    private Permutations solution;
    private int[] nums;
    private List<List<Integer>> expected;

    @Before
    public void init() {
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
    public void testPermute() {
        List<List<Integer>> result = solution.permute(nums);
        Assert.assertEquals(expected, result);
    }
}
