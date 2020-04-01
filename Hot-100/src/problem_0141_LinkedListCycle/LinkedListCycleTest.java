package problem_0141_LinkedListCycle;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleTest {
    LinkedListCycle solution;
    ListNode head;
    boolean expected;

    @Before
    public void setUp() {
        solution = new LinkedListCycle();
        head = ListNode.of(3, 2, 0, -4);
        head.get(3).next = head.get(1);
        expected = true;
    }

    @Test
    public void testHasCycle1() {
        boolean result = solution.hasCycle1(head);
        assertEquals(expected, result);
    }

    @Test
    public void testHasCycle2() {
        boolean result = solution.hasCycle2(head);
        assertEquals(expected, result);
    }
}