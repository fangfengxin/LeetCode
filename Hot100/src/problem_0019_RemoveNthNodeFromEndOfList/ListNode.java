package problem_0019_RemoveNthNodeFromEndOfList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    private ListNode add(int x) {
        ListNode listNode = this;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(x);
        return this;
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
        String result = "";
        ListNode temp = this;
        while (temp != null) {
            if (temp.next == null) {
                result += temp.val;
            } else {
                result += temp.val + "->";
            }
            temp = temp.next;
        }
        return result;
    }
}
