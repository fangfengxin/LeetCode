package July.problem_0108_ConvertSortedArrayToBinarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/3 16:44
 */
class ConvertSortedArrayToBinarySearchTreeTest {
    private ConvertSortedArrayToBinarySearchTree solution;
    private int[] nums;
    private TreeNode expected;

    @BeforeEach
    void setUp() {
        solution = new ConvertSortedArrayToBinarySearchTree();
        nums = new int[]{-10, -3, 0, 5, 9};
        expected = TreeNode.of(0, -3, 9, -10, null, 5);
    }

    @Test
    void sortedArrayToBST() {
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(expected.toString(), result.toString());
    }
}