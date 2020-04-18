package problem_0399_EvaluateDivision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/4/18 13:00
 */
class EvaluateDivisionTest {
    private EvaluateDivision solution;
    private List<List<String>> equations;
    private double[] values;
    private List<List<String>> queries;
    private double[] expected;

    @BeforeEach
    void setUp() {
        solution = new EvaluateDivision();
        equations = Arrays.asList(List.of("a", "b"), List.of("b", "c"));
        values = new double[]{2.0, 3.0};
        queries = Arrays.asList(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        expected = new double[]{6.0, 0.5, -1.0, 1.0, -1.0};
    }

    @Test
    void calcEquation1() {
        double[] result = solution.calcEquation1(equations, values, queries);
        assertArrayEquals(expected, result);
    }

    @Test
    void calcEquation2() {
        double[] result = solution.calcEquation2(equations, values, queries);
        assertArrayEquals(expected, result);
    }
}