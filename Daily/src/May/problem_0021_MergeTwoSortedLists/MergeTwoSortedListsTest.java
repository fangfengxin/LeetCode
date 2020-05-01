package May.problem_0021_MergeTwoSortedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/1 18:36
 */
class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution;
    private ListNode l1;
    private ListNode l2;
    private ListNode expected;

    @BeforeEach
    void setUp() {
        solution = new MergeTwoSortedLists();
        l1 = ListNode.of(1, 2, 4);
        l2 = ListNode.of(1, 3, 4);
        expected = ListNode.of(1, 1, 2, 3, 4, 4);
    }

    @Test
    void mergeTwoLists() {
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertEquals(expected.toString(), result.toString());
    }
}