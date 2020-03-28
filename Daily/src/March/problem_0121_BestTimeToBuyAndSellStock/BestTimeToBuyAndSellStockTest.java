package March.problem_0121_BestTimeToBuyAndSellStock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    private BestTimeToBuyAndSellStock solution;
    private int[] prices;
    private int expected;

    @Before
    public void setUp() {
        solution = new BestTimeToBuyAndSellStock();
        prices = new int[]{7, 1, 5, 3, 6, 4};
        expected = 5;
    }

    @Test
    public void testMaxProfit1() {
        int result = solution.maxProfit1(prices);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void testMaxProfit2() {
        int result = solution.maxProfit2(prices);
        Assert.assertEquals(expected, result);
    }

}