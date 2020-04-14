package April.problem_0445_AddTwoNumbersII;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.*;

public class AddTwoNumbersIITest {
    private AddTwoNumbersII solution;
    private ListNode l1;
    private ListNode l2;
    private ListNode expected;

    @Before
    public void setUp() {
        solution = new AddTwoNumbersII();
        l1 = ListNode.of(7, 2, 4, 3);
        l2 = ListNode.of(5, 6, 4);
        expected = ListNode.of(7, 8, 0, 7);
    }

    @Test
    public void testAddTwoNumbers1() {
        ListNode result = solution.addTwoNumbers1(l1, l2);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testAddTwoNumbers2() {
        ListNode result = solution.addTwoNumbers2(l1, l2);
        assertEquals(expected.toString(), result.toString());
    }
}