package April.problem_0151_ReverseWordsInString;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInStringTest {
    private ReverseWordsInString solution;
    private String s;
    private String expected;

    @Before
    public void setUp() {
        solution = new ReverseWordsInString();
        s = "  hello world!  ";
        expected = "world! hello";
    }

    @Test
    public void testReverseWords1() {
        String result = solution.reverseWords1(s);
        assertEquals(expected, result);
    }

    @Test
    public void testReverseWords2() {
        String result = solution.reverseWords2(s);
        assertEquals(expected, result);
    }

    @Test
    public void testReverseWords3() {
        String result = solution.reverseWords3(s);
        assertEquals(expected, result);
    }
}