package May.problem_0003_LongestSubstringWithoutRepeatingCharacters;

/*
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
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
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 * @Author hustffx
 * @Date 2020/5/2 9:59
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 方法：滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int c1 = s.charAt(right);
            map[c1]++;
            if (map[c1] == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                while (map[c1] != 1 && left < right) {
                    int c2 = s.charAt(left);
                    map[c2]--;
                    left++;
                }
            }
            right++;
        }
        return maxLen;
    }
}
