package April.problem_0072_EditDistance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
    EditDistance solution;
    String word1, word2;
    int expected;

    @Before
    public void setUp() {
        solution = new EditDistance();
        word1 = "horse";
        word2 = "ros";
        expected = 3;
    }

    @Test
    public void testMinDistance() {
        int result = solution.minDistance(word1, word2);
        assertEquals(expected, result);
    }
}