package problem_0076_MinimumWindowSubstring;

import java.util.HashMap;

/*
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinimumWindowSubstring {
    /*
     * 方法：滑动窗口
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int match = 0;
        int minLen = s.length() + 1;
        int minStart = -1;
        HashMap<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c1 = s.charAt(right++);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }

            while (match == needs.size()) {
                if (minLen > right - left) {
                    minLen = right - left;
                    minStart = left;
                }
                char c2 = s.charAt(left++);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
            }
        }

        return minStart < 0 ? "" : s.substring(minStart, minStart + minLen);
    }
}
