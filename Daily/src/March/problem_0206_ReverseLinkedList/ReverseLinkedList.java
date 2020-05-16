package March.problem_0206_ReverseLinkedList;

/*
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

import utils.ListNode;

/**
 * @author hustffx
 */
public class ReverseLinkedList {
    /**
     * 方法1：递归
     */
    public ListNode reverseList1(ListNode head) {
        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    /**
     * 方法2：迭代
     */
    public ListNode reverseList2(ListNode head) {
        ListNode res = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = res;
            res = tmp;
            tmp = next;
        }
        return res;
    }
}
