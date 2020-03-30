package March.problem_0206_ReverseLinkedList;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {
    ReverseLinkedList solution;
    ListNode head, expected;

    @Before
    public void setUp() {
        solution = new ReverseLinkedList();
        head = ListNode.addAll();
        expected = ListNode.addAll();
    }

    @Test
    public void testReverseList1() {
        ListNode result = solution.reverseList1(head);
        assertEquals(expected, result);
    }

    @Test
    public void testReverseList2() {
        ListNode result = solution.reverseList2(head);
        assertEquals(expected, result);
    }
}