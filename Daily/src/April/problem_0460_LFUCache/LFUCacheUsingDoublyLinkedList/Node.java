package April.problem_0460_LFUCache.LFUCacheUsingDoublyLinkedList;

/**
 * 定义双向链表节点，存储 key 和 value
 */
public class Node {
    int key;
    int value;
    int freq;
    // 前驱节点
    Node pre;
    // 后继节点
    Node next;
    // 当前节点所在的链表
    DoublyLinkedList curList;

    public Node() {
        this.freq = 1;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
