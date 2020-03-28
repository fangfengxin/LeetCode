package March.problem_1160_FindWordsThatCanBeFormedByCharacters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindWordsThatCanBeFormedByCharactersTest {
    FindWordsThatCanBeFormedByCharacters solution;
    String[] words;
    String chars;
    int expected;

    @Before
    public void setUp() {
        solution = new FindWordsThatCanBeFormedByCharacters();
        words = new String[]{"cat", "bt", "hat", "tree"};
        chars = "atach";
        expected = 6;
    }

    @Test
    public void testCountCharacters() {
        int result = solution.countCharacters(words, chars);
        assertEquals(expected, result);
    }
}