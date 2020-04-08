package April.problem_interview_13_MovingCount;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovingCountTest {
    MovingCount solution;
    int m, n, k, expected;

    @Before
    public void setUp() {
        solution = new MovingCount();
        m = 2;
        n = 3;
        k = 1;
        expected = 3;
    }

    @Test
    public void testMovingCount() {
        int result = solution.movingCount(m, n, k);
        assertEquals(expected, result);
    }
}