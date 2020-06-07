package June.problem_0126_WordLadderII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/7 13:37
 */
class WordLadderIITest {
    private WordLadderII solution;
    private String beginWord;
    private String endWord;
    private List<String> wordList;
    private List<List<String>> expected;

    @BeforeEach
    void setUp() {
        solution = new WordLadderII();
        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        expected = Arrays.asList(
                Arrays.asList("hit", "hot", "dot", "dog", "cog"),
                Arrays.asList("hit", "hot", "lot", "log", "cog")
        );
    }

    @Test
    void findLadders() {
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        assertEquals(expected, result);
    }
}