package April.problem_0460_LFUCache.LFUCacheWithPriorityQueue;

/**
 * 实现针对小根堆类型的节点
 */
public class Node implements Comparable<Node> {
    int key;
    int value;
    int freq;
    int index;

    public Node(int key, int value, int index) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.index = index;
    }

    @Override
    public int compareTo(Node node) {
        return (this.freq != node.freq) ? (this.freq - node.freq) : (this.index - node.index);
    }
}
