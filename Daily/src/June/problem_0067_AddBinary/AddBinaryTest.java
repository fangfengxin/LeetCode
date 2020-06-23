package June.problem_0067_AddBinary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/23 21:11
 */
class AddBinaryTest {
    private AddBinary solution;
    private String a;
    private String b;
    private String expected;


    @BeforeEach
    void setUp() {
        solution = new AddBinary();
        a = "1010";
        b = "1011";
        expected = "10101";
    }

    @Test
    void addBinary() {
        String result = solution.addBinary(a, b);
        assertEquals(expected, result);
    }
}