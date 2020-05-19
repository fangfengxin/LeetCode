package May.problem_0680_ValidPalindromeII;

/*
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意: 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */

/**
 * @Author hustffx
 * @Date 2020/5/19 14:56
 */
public class ValidPalindromeII {
    /**
     * 方法：贪心算法
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }

            i++;
            j--;
        }

        return true;
    }

    /**
     * 判断 s[i, j] 是否为回文字符串
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
