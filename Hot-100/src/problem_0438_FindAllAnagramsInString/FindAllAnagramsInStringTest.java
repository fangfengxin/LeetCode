package problem_0438_FindAllAnagramsInString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/20 15:37
 */
class FindAllAnagramsInStringTest {
    private FindAllAnagramsInString solution;
    private String s;
    private String p;
    private List<Integer> expected;

    @BeforeEach
    void setUp() {
        solution = new FindAllAnagramsInString();
        s = "cbaebabacd";
        p = "abc";
        expected = List.of(0, 6);
    }

    @Test
    void findAnagrams1() {
        List<Integer> result = solution.findAnagrams1(s, p);
        assertEquals(expected, result);
    }

    @Test
    void findAnagrams2() {
        List<Integer> result = solution.findAnagrams2(s, p);
        assertEquals(expected, result);
    }
}