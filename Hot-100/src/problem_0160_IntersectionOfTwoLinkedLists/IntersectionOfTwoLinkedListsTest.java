package problem_0160_IntersectionOfTwoLinkedLists;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class IntersectionOfTwoLinkedListsTest {
    IntersectionOfTwoLinkedLists solution;
    ListNode headA, headB, expected;

    @Before
    public void setUp() {
        solution = new IntersectionOfTwoLinkedLists();
        headA = ListNode.of(4, 1);
        headB = ListNode.of(5, 0, 1);
        expected = ListNode.of(8, 4, 5);
        headA.get(1).next = expected;
        headB.get(2).next = expected;
    }

    @Test
    public void testGetIntersectionNode1() {
        ListNode result = solution.getIntersectionNode1(headA, headB);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testGetIntersectionNode2() {
        ListNode result = solution.getIntersectionNode2(headA, headB);
        assertEquals(expected.toString(), result.toString());
    }
}