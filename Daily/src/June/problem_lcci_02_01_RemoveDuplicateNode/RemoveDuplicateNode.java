package June.problem_lcci_02_01_RemoveDuplicateNode;

/*
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 提示：
 * 1. 链表长度在[0, 20000]范围内。
 * 2. 链表元素在[0, 20000]范围内。
 *
 * 进阶：如果不得使用临时缓冲区，该怎么解决？
 */

import utils.ListNode;

import java.util.HashSet;

/**
 * @Author hustffx
 * @Date 2020/6/26 0:47
 */
public class RemoveDuplicateNode {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = head;

        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
                set.add(head.val);
            }
        }

        return res;
    }
}
