package problem_0072_EditDistance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {
    EditDistance solution;
    String word1, word2;
    int expected;

    @Before
    public void setUp() {
        solution = new EditDistance();
        word1 = "intention";
        word2 = "execution";
        expected = 5;
    }

    @Test
    public void testMinDistance() {
        int result = solution.minDistance(word1, word2);
        assertEquals(expected, result);
    }
}