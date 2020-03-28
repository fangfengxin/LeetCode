package March.problem_0820_ShortestEncodingOfWords;

import java.util.*;

/*
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 * 提示：
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 */
public class ShortestEncodingOfWords {
    /*
     * 方法1：存储后缀
     * 保留所有不是其他单词后缀的单词。
     * 最后的结果就是这些单词长度加 1 的总和，因为每个单词编码后后面还需要跟一个 # 符号。
     */
    public int minimumLengthEncoding1(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        /*
         * 删除所有可以包含在当前单词后缀中的单词。
         * 迭代过程中删除元素会报错 ConcurrentModificationException。
         * 因而使用 List 存储需要删除的元素，迭代完毕再使用 Set 的 removeAll 方法一起删除。
         */
        List<String> delete = new ArrayList<>();
        for (String word : set) {
            for (int i = 1; i < word.length(); i++) {
                String substr = word.substring(i);
                if (set.contains(substr) && !delete.contains(substr)) {
                    delete.add(substr);
                }
            }
        }
        set.removeAll(delete);
        int res = 0;
        for (String word : set) {
            res += word.length() + 1;
        }
        return res;
    }

    /*
     * 方法2：字典树
     * 我们只要把单词的倒序插入字典树，再用字典树判断某个单词的逆序是否出现在字典树里就可以了。
     * 字典树的叶子节点就代表最长的单词，统计叶子节点代表的单词长度加一的和即为我们要的答案。
     * 例如，我们有 "time" 和 "me"，可以将 "emit" 和 "em" 插入字典树中。
     */
    public int minimumLengthEncoding2(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        int res = 0;
        TrieNode trie = new TrieNode();
        for (String word : words) {
            res += trie.insert(word);
        }
        return res;
    }

    /*
     * 方法3：反转 + 字典排序
     * 所有单词反转之后，我们的单词排序规则变成了字典顺序
     */
    public int minimumLengthEncoding3(String[] words) {
        int n = words.length;
        // 借助 StringBuilder 反转所有单词后排序
        String[] reverse = new String[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = new StringBuilder(words[i]).reverse().toString();
        }
        Arrays.sort(reverse);
        // 检查排序后的每一个单词，如果当前单词是下一个单词的前缀，则将单词丢弃
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && reverse[i + 1].startsWith(reverse[i])) {
                continue;
            }
            res += reverse[i].length() + 1;
        }
        return res;
    }
}
