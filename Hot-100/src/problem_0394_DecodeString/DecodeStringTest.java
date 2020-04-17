package problem_0394_DecodeString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/17 14:56
 */
class DecodeStringTest {
    private DecodeString solution;
    private String s;
    private String expected;

    @BeforeEach
    void setUp() {
        solution = new DecodeString();
        s = "3[a2[c]]";
        expected = "accaccacc";
    }

    @Test
    void decodeString1() {
        String result = solution.decodeString1(this.s);
        assertEquals(expected, result);
    }

    @Test
    void decodeString2() {
        String result = solution.decodeString2(this.s);
        assertEquals(expected, result);
    }
}