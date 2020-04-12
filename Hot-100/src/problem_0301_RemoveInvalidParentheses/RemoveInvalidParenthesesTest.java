package problem_0301_RemoveInvalidParentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveInvalidParenthesesTest {
    private RemoveInvalidParentheses solution;
    private String s;
    private List<String> expected;

    @Before
    public void setUp() {
        solution = new RemoveInvalidParentheses();
        s = "(a)())()";
        expected = Arrays.asList("(a)()()", "(a())()");
    }

    @Test
    public void testRemoveInvalidParentheses() {
        List<String> result = solution.removeInvalidParentheses(s);
        assertEquals(expected, result);
    }
}