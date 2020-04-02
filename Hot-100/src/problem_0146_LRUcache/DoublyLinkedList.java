package problem_0146_LRUcache;

/**
 * 定义双向链表
 */
public class DoublyLinkedList {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 添加节点到双向链表头部
     *
     * @param node
     */
    public void add(DoublyLinkedListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 将节点从双向链表中删除
     *
     * @param node
     */
    public void remove(DoublyLinkedListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    /**
     * 将节点移到双向链表头部
     *
     * @param node
     */
    public void moveToHead(DoublyLinkedListNode node) {
        remove(node);
        add(node);
    }

    /**
     * 移除双向链表的尾部节点
     */
    public DoublyLinkedListNode popTail() {
        DoublyLinkedListNode last = tail.pre;
        remove(last);
        return last;
    }
}
