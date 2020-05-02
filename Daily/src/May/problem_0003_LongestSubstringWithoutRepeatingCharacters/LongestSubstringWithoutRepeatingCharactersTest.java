package May.problem_0003_LongestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/2 10:03
 */
class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters solution;
    private String s;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
        s = "pwwkew";
        expected = 3;
    }

    @Test
    void lengthOfLongestSubstring() {
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }
}