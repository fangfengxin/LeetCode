package problem_0114_FlattenBinaryTreeToLinkedList;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class FlattenBinaryTreeToLinkedListTest {
    FlattenBinaryTreeToLinkedList solution;
    TreeNode root, expected;

    @Before
    public void setUp() {
        solution = new FlattenBinaryTreeToLinkedList();
        root = TreeNode.of(1, 2, 3, null, null, 4, null, null, 5, null, 6);
        expected = TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6);
    }

    @Test
    public void testFlatten1() {
        solution.flatten1(root);
        assertEquals(expected.toString(), root.toString());
    }

    @Test
    public void testFlatten2() {
        solution.flatten2(root);
        assertEquals(expected.toString(), root.toString());
    }

    @Test
    public void testFlatten3() {
        solution.flatten3(root);
        assertEquals(expected.toString(), root.toString());
    }

    @Test
    public void testFlatten4() {
        solution.flatten4(root);
        assertEquals(expected.toString(), root.toString());
    }
}