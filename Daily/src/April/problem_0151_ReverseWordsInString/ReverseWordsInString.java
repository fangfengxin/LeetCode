package April.problem_0151_ReverseWordsInString;

/*
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 进阶：
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    /**
     * 方法1：利用语言特性
     */
    public String reverseWords1(String s) {
        // 除去首尾的连续空格
        s = s.trim();
        // 正则匹配的连续空格作为分隔符
        String[] words = s.split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 方法2：双指针
     * 倒序遍历字符串 s ，记录单词左右索引边界 i , j ；
     * 每确定一个单词的边界，则将其添加至单词列表 res ；
     * 最终，将单词列表拼接为字符串，并返回即可。
     */
    public String reverseWords2(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder sb = new StringBuilder();
        // 从右向左遍历字符串
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            sb.append(s, i + 1, j + 1).append(' ');
            // 跳过单词间的空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    /**
     * 方法3：分割单词
     */
    public String reverseWords3(String s) {
        s = s.trim();
        if (s.equals("")) {
            return s;
        }
        // 按照空格划分单词（因为有连续空格，所以会出现空单词""）
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        // 逆序遍历单词数组
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            sb.append(words[i]);
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
