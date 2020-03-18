package problem_0079_WordSearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {
    WordSearch solution;
    char[][] board;
    String word;
    boolean expected;

    @Before
    public void setUp() {
        solution = new WordSearch();
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        /*word = "ABCB";
        expected = false;*/
        word = "SEE";
        expected = true;
    }

    @Test
    public void testExist() {
        boolean result = solution.exist(board, word);
        assertEquals(expected, result);
    }
}