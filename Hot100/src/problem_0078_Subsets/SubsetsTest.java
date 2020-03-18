package problem_0078_Subsets;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {
    Subsets solution;
    int[] nums;
    List<List<Integer>> expected;

    @Before
    public void setUp() {
        solution = new Subsets();
        nums = new int[]{1, 2, 3};
        expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3)
        );
    }

    @Test
    public void testSubsets1() {
        List<List<Integer>> result = solution.subsets1(nums);
        sortList(result);
        assertEquals(expected, result);
    }

    @Test
    public void testSubsets2() {
        List<List<Integer>> result = solution.subsets2(nums);
        sortList(result);
        assertEquals(expected, result);
    }

    private void sortList(List<List<Integer>> result) {
        result.sort((o1, o2) -> {
            if (o1.size() != o2.size()) {
                return o1.size() - o2.size();
            } else {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i))) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
    }
}