package May.problem_0210_CourseScheduleII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/5/17 12:01
 */
class CourseScheduleIITest {
    private CourseScheduleII solution;
    private int numCourses;
    private int[][] prerequisites;
    private int[][] expected;

    @BeforeEach
    void setUp() {
        solution = new CourseScheduleII();
        numCourses = 4;
        prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        expected = new int[][]{{0, 2, 1, 3}, {0, 1, 2, 3}};
    }

    @Test
    void findOrder1() {
        int[] result = solution.findOrder1(numCourses, prerequisites);
        assertArrayEquals(expected[0], result);
    }

    @Test
    void findOrder2() {
        int[] result = solution.findOrder2(numCourses, prerequisites);
        assertArrayEquals(expected[1], result);
    }
}