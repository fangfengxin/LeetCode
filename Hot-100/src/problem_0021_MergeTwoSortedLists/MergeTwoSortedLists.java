package problem_0021_MergeTwoSortedLists;

/*
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

import utils.ListNode;

/**
 * @author fengxin.fang
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0), node = list;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    node = node.next;
                    l2 = l2.next;
                }
            } else {
                if (l1 != null) {
                    node.next = l1;
                    l1 = null;
                }
                if (l2 != null) {
                    node.next = l2;
                    l2 = null;
                }
            }
        }
        return list.next;
    }
}
