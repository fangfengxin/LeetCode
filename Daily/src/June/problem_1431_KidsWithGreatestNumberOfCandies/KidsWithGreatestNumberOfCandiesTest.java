package June.problem_1431_KidsWithGreatestNumberOfCandies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/6/1 15:00
 */
class KidsWithGreatestNumberOfCandiesTest {
    private KidsWithGreatestNumberOfCandies solution;
    private int[] candies;
    private int extraCandies;
    private List<Boolean> expected;

    @BeforeEach
    void setUp() {
        solution = new KidsWithGreatestNumberOfCandies();
        candies = new int[]{2, 3, 5, 1, 3};
        extraCandies = 3;
        expected = Arrays.asList(true, true, true, false, true);
    }

    @Test
    void kidsWithCandies() {
        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);
        assertEquals(expected, result);
    }
}