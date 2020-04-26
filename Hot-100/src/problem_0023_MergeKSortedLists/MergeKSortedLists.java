package problem_0023_MergeKSortedLists;
/*
 * 合并 k 个排序链表，返回合并后的排序链表。
 * 请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hustffx
 */
public class MergeKSortedLists {
    /**
     * 方法1：暴力破解
     * 将所有节点加入链表，然后排序
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                nums.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(nums);
        ListNode result = new ListNode(0);
        ListNode node = result;
        for (Integer num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return result.next;
    }

    /**
     * 方法2：逐一比较k个链表的首元素
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(0);
        mergeLists(head, lists);
        return head.next;
    }

    private void mergeLists(ListNode head, ListNode[] lists) {
        // 当前k个链表的首元素的最小值
        int min = Integer.MAX_VALUE;
        // 要加入head的链表索引
        int index = -1;
        // 记录已经遍历完的链表数目
        int count = 0;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            } else {
                count++;
            }
        }

        if (count == lists.length) {
            return;
        }

        head.next = new ListNode(lists[index].val);
        lists[index] = lists[index].next;
        mergeLists(head.next, lists);
    }

    /**
     * 方法3：用优先队列优化逐一比较的方法
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }

    /**
     * 方法4：两两合并
     * 将数组的前一半与后一半两两合并，逐渐将数组减半
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[length - 1 - i]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode node = list;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    node = node.next;
                    l1 = l1.next;
                } else {
                    node.next = new ListNode(l2.val);
                    node = node.next;
                    l2 = l2.next;
                }
            } else {
                if (l1 != null) {
                    node.next = l1;
                    l1 = null;
                } else {
                    node.next = l2;
                    l2 = null;
                }
            }
        }
        return list.next;
    }
}
