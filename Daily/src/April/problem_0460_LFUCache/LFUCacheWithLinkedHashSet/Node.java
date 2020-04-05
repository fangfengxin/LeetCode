package April.problem_0460_LFUCache.LFUCacheWithLinkedHashSet;

/**
 * 定义节点，存储 key 和 value
 */
public class Node {
    int key;
    int value;
    int freq;

    public Node() {
        this.freq = 1;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
