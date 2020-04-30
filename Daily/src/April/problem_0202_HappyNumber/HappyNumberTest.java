package April.problem_0202_HappyNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/30 15:41
 */
class HappyNumberTest {
    private HappyNumber solution;
    private int n;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new HappyNumber();
        n = 19;
        expected = true;
    }

    @Test
    void isHappy1() {
        boolean result = solution.isHappy1(n);
        assertEquals(expected, result);
    }

    @Test
    void isHappy2() {
        boolean result = solution.isHappy2(n);
        assertEquals(expected, result);
    }

    @Test
    void isHappy3() {
        boolean result = solution.isHappy3(n);
        assertEquals(expected, result);
    }
}