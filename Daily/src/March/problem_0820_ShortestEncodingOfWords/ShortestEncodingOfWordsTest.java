package March.problem_0820_ShortestEncodingOfWords;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestEncodingOfWordsTest {
    ShortestEncodingOfWords solution;
    String[] words;
    int expected;

    @Before
    public void setUp() {
        solution = new ShortestEncodingOfWords();
        words = new String[]{"time", "me", "bell"};
        expected = 10;
    }

    @Test
    public void testMinimumLengthEncoding1() {
        int result = solution.minimumLengthEncoding1(words);
        assertEquals(expected, result);
    }

    @Test
    public void testMinimumLengthEncoding2() {
        int result = solution.minimumLengthEncoding2(words);
        assertEquals(expected, result);
    }

    @Test
    public void testMinimumLengthEncoding3() {
        int result = solution.minimumLengthEncoding3(words);
        assertEquals(expected, result);
    }
}