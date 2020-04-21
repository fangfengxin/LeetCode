package problem_0647_PalindromicSubstrings;

/*
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 注意: 输入的字符串长度不会超过1000。
 */

/**
 * @Author hustffx
 * @Date 2020/4/21 19:35
 */
public class PalindromicSubstrings {
    /**
     * 方法1：中心扩展
     * 在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个：字母，或两个字母中间。
     * 对于每个可能的回文串中心位置，尽可能扩大它的回文区间 [left, right]。
     * 当 left >= 0 and right < N and S[left] == S[right] 时，扩大区间。
     * 此时回文区间表示的回文串为 S[left], S[left+1], ..., S[right]。
     */
    public int countSubstrings1(String s) {
        int n = s.length();
        int count = 0;
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    /**
     * 方法2：动态规划
     * 状态 dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
     * 当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j] = true，否则为 false
     */
    public int countSubstrings2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (chars[i] == chars[j] && (((j - i) < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法3：马拉车算法
     * 在线性时间内找出以任何位置为中心的最大回文串。
     * 预处理：首位添加$，每个字符之间插入#；
     * 这样原回文串的长度len为现在回文串半径r-1，
     * 且原回文串起始位置为现中心位置center减半径再除以2.
     * 然后维护一个中心为i的最长回文串长度的数组，并记录右上界；
     * 每当下一个i落在之前中心的最长串内，先比较对称位置j的最长串和右边界到i的距离；
     * 若小于，则确定当前i的最长串，若大于，则需要比较越界的部分，然后更新中心和右边界。
     */
    public int countSubstrings3(String s) {
        // 预处理
        char[] rebuild = new char[2 * s.length() + 3];
        rebuild[0] = '@';
        rebuild[1] = '#';
        rebuild[rebuild.length - 1] = '$';
        int index = 2;
        for (char c : s.toCharArray()) {
            rebuild[index++] = c;
            rebuild[index++] = '#';
        }

        int[] max = new int[rebuild.length];
        int center = 0;
        int right = 0;
        for (int i = 1; i < max.length - 1; i++) {
            // 利用对称和之前的max值去重
            if (i < right) {
                max[i] = Math.min(right - i, max[2 * center - i]);
            }
            while (rebuild[i + max[i] + 1] == rebuild[i - max[i] - 1]) {
                max[i]++;
            }
            if (i + max[i] > right) {
                center = i;
                right = i + max[i];
            }
        }

        int count = 0;
        for (int m : max) {
            count += (m + 1) / 2;
        }
        return count;
    }
}
