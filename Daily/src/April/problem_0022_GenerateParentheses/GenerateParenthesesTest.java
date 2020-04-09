package April.problem_0022_GenerateParentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenerateParenthesesTest {
    private GenerateParentheses solution;
    private int n;
    private List<String> expected;

    @Before
    public void setUp() {
        solution = new GenerateParentheses();
        n = 3;
        expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    public void testGenerateParenthesis() {
        List<String> result = solution.generateParenthesis(n);
        assertEquals(expected, result);
    }
}