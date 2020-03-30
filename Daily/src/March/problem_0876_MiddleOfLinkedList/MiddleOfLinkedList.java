package March.problem_0876_MiddleOfLinkedList;

import utils.ListNode;

/*
 * 876. 链表的中间结点
 * 给定一个非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 提示：给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleOfLinkedList {
    /**
     * 方法1：快慢指针
     */
    public ListNode middleNode1(ListNode head) {
        ListNode res = head, tmp = head;
        while (tmp != null && tmp.next != null) {
            res = res.next;
            tmp = tmp.next.next;
        }
        return res;
    }

    /**
     * 方法2：数组
     */
    public ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int size = 0;
        while (head != null) {
            A[size++] = head;
            head = head.next;
        }
        return A[size / 2];
    }
}
