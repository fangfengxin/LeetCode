package June.problem_0990_SatisfiailityOfEqualityEquations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/8 11:21
 */
class SatisfiabilityOfEqualityEquationsTest {
    private SatisfiabilityOfEqualityEquations solution;
    private String[] equations;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new SatisfiabilityOfEqualityEquations();
        equations = new String[]{"a==b", "b!=c", "c==a"};
        expected = false;
    }

    @Test
    void equationsPossible() {
        boolean result = solution.equationsPossible(equations);
        assertEquals(expected, result);
    }
}