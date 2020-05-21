package May.problem_0005_LongestPalindrome;

/*
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */

/**
 * @Author hustffx
 * @Date 2020/5/21 0:16
 */
public class LongestPalindrome {
    /**
     * 方法1：动态规划
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // 最长回文串的起始位置
        int start = 0;
        int end = 0;

        // dp数组
        boolean[] dp = new boolean[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                // i和j位置上的两个字符相等时，字符串[i+1, j-1]是不是回文串决定了字符串[i, j]是不是回文字符串
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1]);

                // 新找到的回文串长度不小于之前的长度，则更新回文串的起始位置信息
                if (dp[j] && j - i + 1 >= end - start + 1) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * 方法2：最长公共子串
     * 将字符串翻转，找到匹配的最长公共子串。
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // 翻转字符串
        String reverse = new StringBuilder(s).reverse().toString();

        // 最长回文串的起始位置
        int start = 0;
        int end = 0;

        // dp数组
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                // 当前字符相等时，公共子串长度加1
                if (s.charAt(i) == reverse.charAt(j)) {
                    dp[j] = j == 0 ? 1 : dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }

                // 如果公共子串长度不小于之前获得的回文串长度，且索引还原后确认是回文串，则更新回文串起始位置
                if (dp[j] > end - start + 1 && (n - 1 - j) + (dp[j] - 1) == i) {
                    start = n - 1 - j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * 方法3：中心扩展
     */
    public String longestPalindrome3(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // 回文字符串起始位置
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            // 对两个可能的对称中心进行扩展
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * 对字符串的对称中心[i, j]进行扩展，返回扩展后的回文字符串长度
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int expandCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        // 循环结束后i和j的位置相比真实回文字符串往外扩展了1位
        return j - i - 1;
    }
}
