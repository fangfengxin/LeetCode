package problem_0448_FindAllNumbersDisappearedInArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/20 17:05
 */
class FindAllNumbersDisappearedInArrayTest {
    private FindAllNumbersDisappearedInArray solution;
    private int[] nums;
    private List<Integer> expected;

    @BeforeEach
    void setUp() {
        solution = new FindAllNumbersDisappearedInArray();
        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        expected = List.of(5, 6);
    }

    @Test
    void findDisappearedNumbers1() {
        List<Integer> result = solution.findDisappearedNumbers1(nums);
        assertEquals(expected, result);
    }

    @Test
    void findDisappearedNumbers2() {
        List<Integer> result = solution.findDisappearedNumbers2(nums);
        assertEquals(expected, result);
    }
}