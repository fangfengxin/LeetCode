package May.problem_1371_FindLongestSubstringContainingVowelsInEvenCounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/20 19:08
 */
class FindLongestSubstringContainingVowelsInEvenCountsTest {
    private FindLongestSubstringContainingVowelsInEvenCounts solution;
    private String s;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new FindLongestSubstringContainingVowelsInEvenCounts();
        s = "bcbcbc";
        expected = 6;
    }

    @Test
    void findTheLongestSubstring() {
        int result = solution.findTheLongestSubstring(s);
        assertEquals(expected, result);
    }
}