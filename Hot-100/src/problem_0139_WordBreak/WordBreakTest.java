package problem_0139_WordBreak;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordBreakTest {
    WordBreak solution;
    String s;
    List<String> wordDict;
    boolean expected;

    @Before
    public void setUp() {
        solution = new WordBreak();
        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        expected = false;
    }

    @Test
    public void testWordBreak1() {
        boolean result = solution.wordBreak1(s, wordDict);
        assertEquals(expected, result);
    }

    @Test
    public void testWordBreak2() {
        boolean result = solution.wordBreak2(s, wordDict);
        assertEquals(expected, result);
    }

    @Test
    public void testWordBreak3() {
        boolean result = solution.wordBreak3(s, wordDict);
        assertEquals(expected, result);
    }
}