package April.problem_lcci_08_11_Coin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/23 15:47
 */
class CoinTest {
    private Coin solution;
    private int n;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new Coin();
        n = 900750;
        expected = 504188296;
    }

    @Test
    void waysToChange() {
        int result = solution.waysToChange(n);
        assertEquals(expected, result);
    }
}