package problem_0621_TaskScheduler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 18:07
 */
class TaskSchedulerTest {
    private TaskScheduler solution;
    private char[] tasks;
    private int n;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new TaskScheduler();
        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        n = 2;
        expected = 8;
    }

    @Test
    void leastInterval1() {
        int result = solution.leastInterval1(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void leastInterval2() {
        int result = solution.leastInterval2(tasks, n);
        assertEquals(expected, result);
    }

    @Test
    void leastInterval3() {
        int result = solution.leastInterval3(tasks, n);
        assertEquals(expected, result);
    }
}