package June.problem_0010_RegularExpressionMatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/20 13:51
 */
class RegularExpressionMatchingTest {
    private RegularExpressionMatching solution;
    private String s;
    private String p;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new RegularExpressionMatching();
        s = "mississippi";
        p = "mis*is*p*.";
        expected = false;
    }

    @Test
    void isMatch() {
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }
}