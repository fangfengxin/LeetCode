package May.problem_0025_ReverseNodesInKGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/16 9:38
 */
class ReverseNodesInKGroupTest {
    private ReverseNodesInKGroup solution;
    private ListNode head;
    private int k;
    private ListNode expected;

    @BeforeEach
    void setUp() {
        solution = new ReverseNodesInKGroup();
        head = ListNode.of(1, 2, 3, 4, 5);
        k = 2;
        expected = ListNode.of(2, 1, 4, 3, 5);
    }

    @Test
    void reverseKGroup() {
        ListNode result = solution.reverseKGroup(head, k);
        assertEquals(expected.toString(), result.toString());
    }
}