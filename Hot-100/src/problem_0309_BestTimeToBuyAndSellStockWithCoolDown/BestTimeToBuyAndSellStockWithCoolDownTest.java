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
    public void maxProfit() {
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
    }
}