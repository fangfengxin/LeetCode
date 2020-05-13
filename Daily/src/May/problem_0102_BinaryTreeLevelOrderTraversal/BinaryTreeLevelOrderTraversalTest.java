package May.problem_0102_BinaryTreeLevelOrderTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/13 9:50
 */
class BinaryTreeLevelOrderTraversalTest {
    private BinaryTreeLevelOrderTraversal solution;
    private TreeNode root;
    private List<List<Integer>> expected;

    @BeforeEach
    void setUp() {
        solution = new BinaryTreeLevelOrderTraversal();
        root = TreeNode.of(3, 9, 20, null, null, 15, 7);
        expected = Arrays.asList(
                Collections.singletonList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
    }

    @Test
    void levelOrder1() {
        List<List<Integer>> result = solution.levelOrder1(root);
        assertEquals(expected, result);
    }

    @Test
    void levelOrder2() {
        List<List<Integer>> result = solution.levelOrder2(root);
        assertEquals(expected, result);
    }
}