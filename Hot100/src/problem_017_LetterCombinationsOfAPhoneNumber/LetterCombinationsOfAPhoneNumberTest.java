package problem_017_LetterCombinationsOfAPhoneNumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumberTest {
    private LetterCombinationsOfAPhoneNumber solution;
    private String digits;
    private List<String> expected;

    @Before
    public void init() {
        solution = new LetterCombinationsOfAPhoneNumber();
        digits = "23";
        expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    @Test
    public void testLetterCombinations() {
        List<String> result = solution.letterCombinations(digits);
        Assert.assertEquals(expected, result);
    }
}
