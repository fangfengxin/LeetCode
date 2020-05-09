package May.problem_0069_SqrtX;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/9 10:45
 */
class SqrtXTest {
    private SqrtX solution;
    private int x;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SqrtX();
        x = 2147483647;
        expected = 46340;
    }

    @Test
    void mySqrt1() {
        int result = solution.mySqrt1(x);
        assertEquals(expected, result);
    }

    @Test
    void mySqrt2() {
        int result = solution.mySqrt2(x);
        assertEquals(expected, result);
    }
}