package problem_0146_LRUcache;

/**
 * 定义双向链表节点类型
 */
public class DoublyLinkedListNode {
    public int key;
    public int value;
    DoublyLinkedListNode pre;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
