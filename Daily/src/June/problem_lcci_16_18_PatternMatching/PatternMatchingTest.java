package June.problem_lcci_16_18_PatternMatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/22 13:47
 */
class PatternMatchingTest {
    private PatternMatching solution;
    private String pattern;
    private String value;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new PatternMatching();
        pattern = "abba";
        value = "dogcatcatdog";
        expected = true;
    }

    @Test
    void patternMatching() {
        boolean result = solution.patternMatching(pattern, value);
        assertEquals(expected, result);
    }
}