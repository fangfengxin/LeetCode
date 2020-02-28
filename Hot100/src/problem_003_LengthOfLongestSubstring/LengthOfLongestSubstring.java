package problem_003_LengthOfLongestSubstring;

/*
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import org.jetbrains.annotations.NotNull;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    /*
     * 方法1：暴力破解
     * 逐个检查所有的子字符串，看它是否不含有重复的字符。
     */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                boolean noRepeatedChar = isNoRepeatedChar(s.substring(i, j));
                if (noRepeatedChar) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    public boolean isNoRepeatedChar(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    /*
     * 方法2：滑动窗口
     * 使用HashSet做滑动窗口，完成对子字符串的检查。
     */
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length(), i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    /*
     * 方法3：优化的滑动窗口
     * 使用HashMap作为滑动窗口，存储字符到索引的映射，遇到重复字符，
     * 将窗口最小值直接跳到前面一个重复字符的下一个位置，而不用再逐一增加。
     */
    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        HashMap map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max((Integer) map.get(c), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(c, j + 1);
        }
        return result;
    }

    /*
     * 方法4：字符集较小时，使用数组来代替滑动窗口
     */
    public int lengthOfLongestSubstring4(String s) {
        int result = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            i = Math.max(index[c], i);
            result = Math.max(result, j - i + 1);
            index[c] = j + 1;
        }
        return result;
    }
}
