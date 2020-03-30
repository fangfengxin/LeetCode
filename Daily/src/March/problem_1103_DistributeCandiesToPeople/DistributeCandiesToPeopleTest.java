package March.problem_1103_DistributeCandiesToPeople;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DistributeCandiesToPeopleTest {
    DistributeCandiesToPeople solution;
    int candies, num_people;
    int[] expected;

    @Before
    public void setUp() {
        solution = new DistributeCandiesToPeople();
        candies = 10;
        num_people = 3;
        expected = new int[]{5, 2, 3};
    }

    @Test
    public void testDistributeCandies1() {
        int[] result = solution.distributeCandies1(candies, num_people);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDistributeCandies2() {
        int[] result = solution.distributeCandies2(candies, num_people);
        assertArrayEquals(expected, result);
    }
}