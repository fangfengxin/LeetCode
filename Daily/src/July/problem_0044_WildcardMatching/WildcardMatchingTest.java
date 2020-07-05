package July.problem_0044_WildcardMatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/5 22:16
 */
class WildcardMatchingTest {
    private WildcardMatching solution;
    private String s;
    private String p;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new WildcardMatching();
        s = "acdcb";
        p = "a*c?b";
        expected = false;
    }

    @Test
    void isMatch() {
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }
}