package problem_0072_EditDistance;

/*
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class EditDistance {
    /*
     * 方法1：动态规划
     * D[i][j] 表示 word1 的前 i 个字母和 word2 的前 j 个字母之间的编辑距离。
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 有一个空串
        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];
        // 边界情况：空串
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }

        // 动态规划
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                /*int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int left_top = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_top++;
                }
                dp[i][j] = Math.min(Math.min(left, top), left_top);*/

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] - 1);
                }
            }
        }
        return dp[m][n];
    }
}
