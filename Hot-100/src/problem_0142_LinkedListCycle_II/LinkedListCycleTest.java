package problem_0142_LinkedListCycle_II;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleTest {
    LinkedListCycle solution;
    ListNode head, expected;

    @Before
    public void setUp() {
        solution = new LinkedListCycle();
        head = ListNode.of(3, 2, 0, -4);
        head.get(3).next = head.get(1);
        expected = ListNode.of(2);
    }

    @Test
    public void testDetectCycle1() {
        ListNode result = solution.detectCycle1(head);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testDetectCycle2() {
        ListNode result = solution.detectCycle2(head);
        assertEquals(expected.toString(), result.toString());
    }
}