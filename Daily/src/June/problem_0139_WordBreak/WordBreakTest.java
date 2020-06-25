package June.problem_0139_WordBreak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/25 11:31
 */
class WordBreakTest {
    private WordBreak solution;
    private String s;
    private List<String> wordDict;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new WordBreak();
        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        expected = true;
    }

    @Test
    void wordBreak() {
        boolean result = solution.wordBreak(s, wordDict);
        assertEquals(expected, result);
    }
}