package March.problem_0914_XOfAKindInADeckOfCards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XOfAKindInADeckOfCardsTest {
    XOfAKindInADeckOfCards solution;
    int[] deck;
    boolean expected;

    @Before
    public void setUp() {
        solution = new XOfAKindInADeckOfCards();
        deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        expected = true;
    }

    @Test
    public void testHasGroupsSizeX1() {
        boolean result = solution.hasGroupsSizeX1(deck);
        assertEquals(expected, result);
    }

    @Test
    public void testHasGroupsSizeX2() {
        boolean result = solution.hasGroupsSizeX2(deck);
        assertEquals(expected, result);
    }
}