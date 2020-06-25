package June.problem_lcci_02_01_RemoveDuplicateNode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/26 0:48
 */
class RemoveDuplicateNodeTest {
    private RemoveDuplicateNode solution;
    private ListNode head;
    private ListNode expected;

    @BeforeEach
    void setUp() {
        solution = new RemoveDuplicateNode();
        head = ListNode.of(1, 2, 3, 3, 2, 1);
        expected = ListNode.of(1, 2, 3);
    }

    @Test
    void removeDuplicateNodes() {
        ListNode result = solution.removeDuplicateNodes(head);
        assertEquals(expected.toString(), result.toString());
    }
}