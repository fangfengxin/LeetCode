package problem_002_AddTwoNumbers.code;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode add(int x) {
        ListNode listNode = this;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(x);
        return this;
    }

    public static ListNode addAll(int... nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Need list elements");
        }
        ListNode list = new ListNode(0);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode temp = this.next;
        while (temp != null) {
            if(temp.next == null) {
                result += temp.val + "->";
            } else {
                result += temp.val + "->";
            }
            temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.addAll(1, 2, 3).toString());
    }
}
