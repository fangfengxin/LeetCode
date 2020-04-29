package April.problem_1069_FindInMountainArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.MountainArray;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/29 11:03
 */
class FindInMountainArrayTest {
    private FindInMountainArray solution;
    private int target;
    private MountainArray mountainArr;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new FindInMountainArray();
        target = 3;
        mountainArr = new MountainArray() {
            private final int[] arr = new int[]{1, 2, 3, 4, 5, 3, 1};

            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        };
        expected = 2;
    }

    @Test
    void findInMountainArray() {
        int result = solution.findInMountainArray(target, mountainArr);
        assertEquals(expected, result);
    }
}