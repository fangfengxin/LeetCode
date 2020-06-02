package June.problem_lcof_64_SumOf1ToN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/2 12:53
 */
class SumOf1ToNTest {
    private SumOf1ToN solution;
    private int n;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SumOf1ToN();
        n = 9;
        expected = 45;
    }

    @Test
    void sumNums() {
        int result = solution.sumNums(n);
        assertEquals(expected, result);
    }
}