package problem_0142_LinkedListCycle_II;

import utils.ListNode;

import java.util.HashSet;

/*
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class LinkedListCycle {
    /**
     * 方法1：哈希表
     */
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                break;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 方法2：双指针
     * 设表头到环入口的节点数为 a，环内节点数为 b。
     * 快慢指针相遇时, f = 2s, f - s = nb, 则 s = nb。
     * 这时如果将快指针指向表头，两指针以同样速度继续走。
     * 当快指针首次到达环入口时，慢指针也同样到达环入口。
     * 因为此时慢指针走了 a+nb 个节点。
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
