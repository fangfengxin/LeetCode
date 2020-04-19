package April.problem_0466_CountRepetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/19 11:18
 */
class CountRepetitionsTest {
    private CountRepetitions solution;
    private String s1;
    private int n1;
    private String s2;
    private int n2;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new CountRepetitions();
        s1 = "abaacdbac";
        n1 = 100;
        s2 = "adcbd";
        n2 = 4;
        expected = 12;
    }

    @Test
    void getMaxRepetitions() {
        int result = solution.getMaxRepetitions(s1, n1, s2, n2);
        assertEquals(expected, result);
    }
}