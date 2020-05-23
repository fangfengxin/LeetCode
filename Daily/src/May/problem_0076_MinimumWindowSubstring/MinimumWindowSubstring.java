package May.problem_0076_MinimumWindowSubstring;

/*
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 1. 如果 S 中不存在这样的子串，则返回空字符串 ""。
 * 2. 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

/**
 * @Author hustffx
 * @Date 2020/5/23 10:19
 */
public class MinimumWindowSubstring {
    /**
     * 方法：滑动窗口
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        // 字符串t的字符频数数组
        int[] needs = new int[128];
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        // 窗口子串的字符频数数组
        int[] window = new int[128];
        char[] chars = s.toCharArray();

        // 匹配的字符个数
        int match = 0;
        int minLen = sLen + 1;
        int start = -1;

        // 滑动窗口左右指针
        int left = 0;
        int right = 0;

        // 滑动窗口 [left, right)
        while (right < sLen) {
            char c1 = chars[right];

            // 字符没有在字符串t中出现，扩展右边界
            if (needs[c1] == 0) {
                right++;
                continue;
            }

            // 出现次数还不满足要求，需要继续匹配，所以匹配的字符数量+1
            if (window[c1] < needs[c1]) {
                match++;
            }

            // 字符出现在字符串t中，窗口字符频数+1，扩展右边界
            window[c1]++;
            right++;

            // 匹配成功，则缩小左边界至窗口不满足要求
            while (match == tLen) {
                // 当前窗口长度小于之前找到的最小长度，则更新窗口起始位置和长度
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char c2 = chars[left];

                // 字符未在字符串t中出现，则继续缩小左边界
                if (needs[c2] == 0) {
                    left++;
                    continue;
                }

                // 达到当前窗口最小的程度，继续缩小左边界将导致匹配字符数量不满足要求
                if (needs[c2] == window[c2]) {
                    match--;
                }

                // 窗口字符频数-1，缩小左边界
                window[c2]--;
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
