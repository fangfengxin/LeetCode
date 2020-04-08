package problem_0234_PalindromeLinkedList;

import utils.ListNode;

import java.util.ArrayList;

/*
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
    /**
     * 方法1：将值复制到数组中后使用双指针法
     */
    public boolean isPalindrome1(ListNode head) {
        // 将链表转换为数组
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 双指针
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /**
     * 方法2：使用快慢指针将链表分成两段，后半段逆序后跟前半段匹配
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode list = new ListNode(0);
        list.next = head;
        // 快慢指针
        ListNode first = list;
        ListNode second = list;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        // 划分两段
        second = first.next;
        first.next = null;
        first = head;
        // 反转后半段链表
        ListNode pre = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = pre;
            pre = second;
            second = next;
        }
        second = pre;
        // 前后半链表逐一比较
        while (second != null) {
            if (second.val != first.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
