package May.problem_0983_MinimumCostForTickets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/6 12:29
 */
class MinimumCostForTicketsTest {
    private MinimumCostForTickets solution;
    private int[] days;
    private int[] costs;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new MinimumCostForTickets();
        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        costs = new int[]{2, 7, 15};
        expected = 17;
    }

    @Test
    void minCostTickets1() {
        int result = solution.minCostTickets1(days, costs);
        assertEquals(expected, result);
    }

    @Test
    void minCostTickets2() {
        int result = solution.minCostTickets2(days, costs);
        assertEquals(expected, result);
    }
}