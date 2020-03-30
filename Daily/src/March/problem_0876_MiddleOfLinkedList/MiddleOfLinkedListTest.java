package March.problem_0876_MiddleOfLinkedList;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class MiddleOfLinkedListTest {
    MiddleOfLinkedList solution;
    ListNode head, expected;

    @Before
    public void setUp() {
        solution = new MiddleOfLinkedList();
        head = ListNode.addAll(1, 2, 3, 4, 5, 6);
        expected = ListNode.addAll(4, 5, 6);
    }

    @Test
    public void testMiddleNode1() {
        ListNode result = solution.middleNode1(head);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testMiddleNode2() {
        ListNode result = solution.middleNode2(head);
        assertEquals(expected.toString(), result.toString());
    }
}