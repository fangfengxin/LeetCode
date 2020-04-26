package April.problem_0023_MergeKSortedLists;

/*
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author hustffx
 * @Date 2020/4/26 14:37
 */
public class MergeKSortedLists {
    /**
     * 方法1：逐一比较 + 优先队列
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!heap.isEmpty()) {
            node.next = heap.poll();
            node = node.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return head.next;
    }

    /**
     * 方法2：两两合并
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[n - 1 - i]);
            }
            n = (n + 1) / 2;
        }
        return lists[0];
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
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
        return head.next;
    }
}
