package May.problem_0025_ReverseNodesInKGroup;

/*
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 1. 你的算法只能使用常数的额外空间。
 * 2. 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

import utils.ListNode;

/**
 * @Author hustffx
 * @Date 2020/5/16 9:36
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode list = new ListNode(0);
        list.next = head;

        ListNode pre = list;
        ListNode end = pre;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            ListNode start = pre.next;

            ListNode next = end.next;
            end.next = null;

            // 翻转链表 [start...end] -> [end...start]
            pre.next = reverseList(start);
            start.next = next;

            pre = start;
            end = pre;
        }

        return list.next;
    }

    /**
     * 翻转整个链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
