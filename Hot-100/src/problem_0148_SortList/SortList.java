package problem_0148_SortList;

import utils.ListNode;

/*
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class SortList {
    /**
     * 方法：迭代形式的归并排序
     * 根据时间复杂度 O(N log N) 自然联想到二分法，进而联想到归并排序。
     * 数组归并排序的空间复杂度 O(N) 由开辟新数组 O(N) 和递归调用 O(log N) 组成。
     * 在链表中直接通过修改引用来更改节点顺序，不需要开辟额外空间。
     * 但是递归调用将带来 O(log N) 的空间复杂度。
     * 题目要求常数级空间复杂度，因此不能使用递归。
     */
    public ListNode sortList(ListNode head) {
        // 获取链表长度
        int len = getLength(head);
        ListNode res = new ListNode(0);
        res.next = head;
        for (int step = 1; step < len; step *= 2) {
            ListNode pre = res;
            ListNode cur = pre.next;
            while (cur != null) {
                // 定义一个指针指向第一部分
                ListNode first = cur;
                // 定义一个指针指向第二部分
                ListNode second = cut(first, step);
                cur = cut(second, step);
                // 将第一部分和第二部分归并排序
                pre.next = merge(first, second);
                // pre 节点指向归并链表的末尾
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = cur;
            }
        }
        return res.next;
    }

    /**
     * 获取链表长度
     */
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 切分链表
     *
     * @param head
     * @param step 切分长度
     * @return 切分后剩余的链表
     */
    private ListNode cut(ListNode head, int step) {
        while (step > 1 && head != null) {
            head = head.next;
            step--;
        }
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        // 断开当前切分部分与剩余部分
        head.next = null;
        return next;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                tmp = tmp.next;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                tmp = tmp.next;
                list2 = list2.next;
            }
        }
        tmp.next = list1 != null ? list1 : list2;
        return res.next;
    }
}
