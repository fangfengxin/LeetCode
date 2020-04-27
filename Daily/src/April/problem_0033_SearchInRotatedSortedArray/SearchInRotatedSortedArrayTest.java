package April.problem_0033_SearchInRotatedSortedArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/27 13:11
 */
class SearchInRotatedSortedArrayTest {
    private SearchInRotatedSortedArray solution;
    private int[] nums;
    private int target;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SearchInRotatedSortedArray();
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        expected = 4;
    }

    @Test
    void search1() {
        int result = solution.search1(nums, target);
        assertEquals(expected, result);
    }

    @Test
    void search2() {
        int result = solution.search2(nums, target);
        assertEquals(expected, result);
    }
}