package problem_0287_FindDuplicateNumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicateNumberTest {
    private FindDuplicateNumber solution;
    private int[] nums;
    private int expected;

    @Before
    public void setUp() {
        solution = new FindDuplicateNumber();
        nums = new int[]{3, 1, 3, 4, 2};
        expected = 3;
    }

    @Test
    public void findDuplicate1() {
        int result = solution.findDuplicate1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void findDuplicate2() {
        int result = solution.findDuplicate2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void findDuplicate3() {
        int result = solution.findDuplicate3(nums);
        assertEquals(expected, result);
    }

    @Test
    public void findDuplicate4() {
        int result = solution.findDuplicate4(nums);
        assertEquals(expected, result);
    }
}