package problem_0207_CourseSchedule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseScheduleTest {
    boolean expected;
    private CourseSchedule solution;
    private int numCourse;
    private int[][] prerequisites;

    @Before
    public void setUp() {
        solution = new CourseSchedule();
        numCourse = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        expected = false;
    }

    @Test
    public void testCanFinish1() {
        boolean result = solution.canFinish1(numCourse, prerequisites);
        assertEquals(expected, result);
    }

    @Test
    public void testCanFinish2() {
        boolean result = solution.canFinish2(numCourse, prerequisites);
        assertEquals(expected, result);
    }
}