package utils;

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
        return Integer.toString(val);
    }
}
