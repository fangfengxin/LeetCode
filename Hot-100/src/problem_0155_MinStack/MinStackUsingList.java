package problem_0155_MinStack;

/*
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，
 * 并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

/**
 * 用一个链表即可实现栈的基本功能，
 * 可以在 ListNode 节点中增加一个 min 字段，
 * 每次加入一个节点的时候，同时只要确定它的 min 值即可。
 */
public class MinStackUsingList {
    ListNode head;

    /**
     * initialize your data structure here.
     */
    public MinStackUsingList() {
    }

    /**
     * 将元素 x 推入栈中。
     *
     * @param x
     */
    public void push(int x) {
        if (head == null) {
            head = new ListNode(x, x);
        } else {
            ListNode node = new ListNode(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }

    /**
     * 删除栈顶的元素。
     */
    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    /**
     * 获取栈顶元素。
     */
    public int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    /**
     * 检索栈中的最小元素。
     */
    public int getMin() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }

    static class ListNode {
        int val;
        int min;
        ListNode next;

        public ListNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}