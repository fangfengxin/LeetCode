package problem_0021_MergeTwoSortedLists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.ListNode;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution;
    private ListNode l1;
    private ListNode l2;
    private ListNode expected;

    @Before
    public void init() {
        solution = new MergeTwoSortedLists();
        l1 = ListNode.addAll(1, 2, 4);
        l2 = ListNode.addAll(1, 3, 4);
        expected = ListNode.addAll(1, 1, 2, 3, 4, 4);
    }

    @Test
    public void testMergeTwoLists() {
        ListNode result = solution.mergeTwoLists(l1, l2);
        if (result == null || expected == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }
}
