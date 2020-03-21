package problem_0365_WaterAndJugProblem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaterAndJugProblemTest {
    WaterAndJugProblem solution;
    int x, y, z;
    boolean expected;

    @Before
    public void setUp() {
        solution = new WaterAndJugProblem();
        x = 3;
        y = 5;
        z = 4;
        expected = true;
    }

    @Test
    public void testCanMeasureWater1() {
        boolean result = solution.canMeasureWater1(x, y, z);
        assertEquals(expected, result);
    }

    @Test
    public void testCanMeasureWater2() {
        boolean result = solution.canMeasureWater2(x, y, z);
        assertEquals(expected, result);
    }

}