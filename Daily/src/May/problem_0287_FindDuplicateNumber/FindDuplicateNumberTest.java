package May.problem_0287_FindDuplicateNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/26 13:15
 */
class FindDuplicateNumberTest {
    private FindDuplicateNumber solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new FindDuplicateNumber();
        nums = new int[]{3, 1, 3, 4, 2};
        expected = 3;
    }

    @Test
    void findDuplicate1() {
        int result = solution.findDuplicate1(nums);
        assertEquals(expected, result);
    }

    @Test
    void findDuplicate2() {
        int result = solution.findDuplicate2(nums);
        assertEquals(expected, result);
    }
}