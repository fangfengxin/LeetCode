package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    private void add(int x) {
        ListNode listNode = this;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(x);
    }

    public static ListNode addAll(int... nums) {
        ListNode list = new ListNode(0);
        for (int num : nums) {
            list.add(num);
        }
        return list.next;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
