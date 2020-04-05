package April.problem_0460_LFUCache.LFUCacheUsingDoublyLinkedList;

/**
 * 定义存储某一使用频次所有节点的双向链表
 */
public class DoublyLinkedList {
    int freq;
    // 前驱链表
    DoublyLinkedList pre;
    // 后继链表
    DoublyLinkedList next;
    // 头结点，head.next 最近访问
    Node head;
    // 尾结点，tail.pre 最久访问
    Node tail;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public DoublyLinkedList(int freq) {
        this.freq = freq;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 移除节点
     *
     * @param node
     */
    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
        // 设置节点的所在链表
        node.curList = this;
    }
}
