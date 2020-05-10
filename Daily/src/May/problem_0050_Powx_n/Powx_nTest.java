package May.problem_0050_Powx_n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/11 0:25
 */
class Powx_nTest {
    private Powx_n solution;
    private double x;
    private int n;
    private double expected;

    @BeforeEach
    void setUp() {
        solution = new Powx_n();
        x = 2.1;
        n = 3;
        expected = 9.261;
    }

    @Test
    void myPow() {
        double result = solution.myPow(x, n);
        assertEquals(expected, result, 1e-7);
    }
}