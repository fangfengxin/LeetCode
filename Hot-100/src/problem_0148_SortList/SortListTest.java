package problem_0148_SortList;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class SortListTest {
    SortList solution;
    ListNode head, expected;

    @Before
    public void setUp() {
        solution = new SortList();
        head = ListNode.of(-1, 5, 3, 4, 0);
        expected = ListNode.of(-1, 0, 3, 4, 5);
    }

    @Test
    public void testSortList() {
        ListNode result = solution.sortList(head);
        assertEquals(expected.toString(), result.toString());
    }
}