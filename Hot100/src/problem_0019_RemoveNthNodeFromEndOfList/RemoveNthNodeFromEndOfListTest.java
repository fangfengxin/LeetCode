package problem_0019_RemoveNthNodeFromEndOfList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RemoveNthNodeFromEndOfListTest {
    private RemoveNthNodeFromEndOfList solution;
    private ListNode head;
    private int n;
    private ListNode expected;

    @Before
    public void init() {
        solution = new RemoveNthNodeFromEndOfList();
        head = ListNode.addAll(1, 2, 3, 4, 5);
        n = 2;
        expected = ListNode.addAll(1, 2, 3, 5);
        /*head = ListNode.addAll(1);
        n = 1;
        expected = ListNode.addAll();*/
    }

    @Test
    public void testRemoveNthFromEnd() {
        ListNode result = solution.removeNthFromEnd(head, n);
        if (expected == null || result == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }
}
