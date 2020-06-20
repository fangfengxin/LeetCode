package problem_0010_RegularExpressionMatching;

/*
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */

/**
 * @author hustffx
 */
public class RegularExpressionMatching {
    /**
     * 方法1：回溯
     */
    public boolean isMatch1(String text, String pattern) {
        // 如果模式串为空，这时匹配串为空则匹配
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        // 模式串不为空，首先进行首位匹配（首位肯定没有星号）
        boolean firstMatch = !text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
        // 根据是否包含星号*来进行处理
        // 第二位不是*，直接进行下一位的匹配
        // 第二位是*，直接抹除模式串这一部分或者删掉匹配串的第一个字符
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch1(text, pattern.substring(2)) || (firstMatch && isMatch1(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch1(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 方法2：动态规划
     * 因为题目拥有 最优子结构 ，一个自然的想法是将中间结果保存起来。
     * 通过用 dp(i,j) 表示 text[i:] 和 pattern[j:] 是否能匹配。
     * 因为边界出现在尾部，所以使用逆序遍历。
     */
    public boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
                // 模式串遇到星号*，
                // 要么匹配串的第一个字符匹配成功继续匹配下一个，
                // 要么抹掉模式串*之前的字符重新开始匹配。
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
