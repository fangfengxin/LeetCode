package problem_0022_GenerateParentheses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenerateParenthesesTest {
    private GenerateParentheses solution;
    private int n;
    private List<String> expected;

    @Before
    public void init() {
        solution = new GenerateParentheses();
        n = 3;
        expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    public void testGenerateParenthesis1() {
        List<String> result = solution.generateParentheses1(n);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateParenthesis2() {
        List<String> result = solution.generateParentheses2(n);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGenerateParenthesis3() {
        List<String> result = solution.generateParentheses3(n);
        Assert.assertEquals(expected, result);
    }
}
