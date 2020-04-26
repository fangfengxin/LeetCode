package April.problem_0023_MergeKSortedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/26 14:38
 */
class MergeKSortedListsTest {
    private MergeKSortedLists solution;
    private ListNode[] lists;
    private ListNode expected;

    @BeforeEach
    void setUp() {
        solution = new MergeKSortedLists();
        lists = new ListNode[]{
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6)
        };
        expected = ListNode.of(1, 1, 2, 3, 4, 4, 5, 6);
    }

    @Test
    void mergeKLists1() {
        ListNode result = solution.mergeKLists1(lists);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void mergeKLists2() {
        ListNode result = solution.mergeKLists2(lists);
        assertEquals(expected.toString(), result.toString());
    }
}