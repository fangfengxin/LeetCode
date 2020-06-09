package June.problem_lcof_46_Number2String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/9 11:49
 */
class Number2StringTest {
    private Number2String solution;
    private int num;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new Number2String();
        num = 12258;
        expected = 5;
    }

    @Test
    void translateNum1() {
        int result = solution.translateNum1(num);
        assertEquals(expected, result);
    }

    @Test
    void translateNum2() {
        int result = solution.translateNum2(num);
        assertEquals(expected, result);
    }
}