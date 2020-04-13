package problem_0309_BestTimeToBuyAndSellStockWithCoolDown;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSellStockWithCoolDownTest {
    private BestTimeToBuyAndSellStockWithCoolDown solution;
    private int[] prices;
    private int expected;

    @Before
    public void setUp() {
        solution = new BestTimeToBuyAndSellStockWithCoolDown();
        prices = new int[]{1, 2, 3, 0, 2};
        expected = 3;
    }

    @Test
    public void testMaxProfit1() {
        int result = solution.maxProfit1(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfit2() {
        int result = solution.maxProfit2(prices);
        assertEquals(expected, result);
    }
}