package problem_0322_CoinChange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinChangeTest {
    private CoinChange solution;
    private int[] coins;
    private int amount;
    private int expected;

    @Before
    public void init() {
        solution = new CoinChange();
        /*coins = new int[]{389,46,222,352,4,250};
        // 4 46 222 250 352 389
        amount = 5343;
        // 5343-389*13=286-250*1=36-4*9=0
        // 5343-389*13=286-222*1=64-44*1=20-4*5=0
        // 5343-389*13=286-46*5=56-4*14=0
        // 5343-389*11=1064-352*3=8-4*2=0
        expected = 16;*/

        coins = new int[]{2};
        amount = 3;
        expected = -1;
    }

    @Test
    public void testCoinChange1() {
        int result = solution.coinChange1(coins, amount);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCoinChange2() {
        int result = solution.coinChange2(coins, amount);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCoinChange3() {
        int result = solution.coinChange3(coins, amount);
        Assert.assertEquals(expected, result);
    }

}
