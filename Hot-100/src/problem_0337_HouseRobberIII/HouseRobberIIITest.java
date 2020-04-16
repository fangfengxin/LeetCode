package problem_0337_HouseRobberIII;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class HouseRobberIIITest {
    private HouseRobberIII solution;
    private TreeNode root;
    private int expected;

    @Before
    public void setUp() {
        solution = new HouseRobberIII();
        root = TreeNode.of(3, 2, 3, null, 3, null, 1);
        expected = 7;
    }

    @Test
    public void testRob1() {
        int result = solution.rob1(root);
        assertEquals(expected, result);
    }

    @Test
    public void testRob2() {
        int result = solution.rob2(root);
        assertEquals(expected, result);
    }

    @Test
    public void testRob3() {
        int result = solution.rob3(root);
        assertEquals(expected, result);
    }
}