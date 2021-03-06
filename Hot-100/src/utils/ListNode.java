package utils;

import java.util.Objects;

/**
 * 单链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 将一串数字转换为链表
     *
     * @param nums 可变参数，数字个数不限
     */
    public static ListNode of(int... nums) {
        ListNode list = new ListNode(0);
        for (int num : nums) {
            list.add(num);
        }
        return list.next;
    }

    /**
     * 向链表末尾添加节点
     */
    private void add(int x) {
        ListNode listNode = this;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(x);
    }

    /**
     * 获取链表的第 pos 个节点
     *
     * @param pos 从 0 开始
     */
    public ListNode get(int pos) {
        ListNode node = this;
        while (pos > 0) {
            node = node.next;
            pos--;
        }
        return node;
    }

    /**
     * 将链表转换为字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            sb.append(' ');
            node = node.next;
        }
        return sb.toString().strip();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
