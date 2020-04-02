package March.problem_0820_ShortestEncodingOfWords;

/**
 * 定义一个便于处理此题的字典树/前缀树
 */
public class TrieNode {
    public char c;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }

    /**
     * 向字典树中倒序插入一个单词
     */
    public int insert(String word) {
        TrieNode node = this;
        boolean isNew = false; // 标记是否是新单词
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                isNew = true;
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        // 如果是新单词，返回单词长度加 1
        return isNew ? word.length() + 1 : 0;
    }
}
