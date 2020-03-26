package problem_0023_MergeKSortedLists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

public class MergeKSortedListsTest {
    private MergeKSortedLists solution;
    private ListNode[] lists;
    private ListNode expected;

    @Before
    public void init() {
        solution = new MergeKSortedLists();
        lists = new ListNode[]{
                ListNode.addAll(1, 4, 5),
                ListNode.addAll(1, 3, 4),
                ListNode.addAll(2, 6)
        };
        expected = ListNode.addAll(1, 1, 2, 3, 4, 4, 5, 6);
    }

    @Test
    public void testMergeKLists1() {
        ListNode result = solution.mergeKLists1(lists);
        if (result == null || expected == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }

    @Test
    public void testMergeKLists2() {
        ListNode result = solution.mergeKLists2(lists);
        if (result == null || expected == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }

    @Test
    public void testMergeKLists3() {
        ListNode result = solution.mergeKLists3(lists);
        if (result == null || expected == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }

    @Test
    public void testMergeKLists4() {
        ListNode result = solution.mergeKLists4(lists);
        if (result == null || expected == null) {
            Assert.assertEquals(expected, result);
        } else {
            Assert.assertEquals(expected.toString(), result.toString());
        }
    }
}
