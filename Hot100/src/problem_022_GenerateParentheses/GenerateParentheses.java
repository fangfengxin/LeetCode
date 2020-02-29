package problem_022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
 * 给出 n 代表生成括号的对数，请你写出一个函数，
 * 使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    /*
     * 方法1：暴力破解，回溯算法（使用系统栈的深度优先遍历）
     * 生成所有序列，并在生成过程中检查有效性。
     */
    public List<String> generateParentheses1(int n) {
        ArrayList<String> list = new ArrayList<>();
        generateAll(list, new char[2 * n], 0);
        return list;
    }

    private void generateAll(List<String> list, char[] current, int pos) {
        if (pos == current.length) {
            if (isValid(current))
                list.add(new String(current));
            return;
        }
        current[pos] = '(';
        generateAll(list, current, pos + 1);
        current[pos] = ')';
        generateAll(list, current, pos + 1);
    }

    private boolean isValid(char[] current) {
        int valid = 0;
        for (char c : current) {
            if (c == '(')
                valid++;
            else
                valid--;
            if (valid < 0)
                return false;
        }
        return valid == 0;
    }

    /*
     * 方法2：简化回溯算法
     * 只有在知道序列仍然保持有效时才添加 '(' 或 ')'，
     * 通过存储目前的左右括号个数来判断添加什么。
     */
    public List<String> generateParentheses2(int n) {
        ArrayList<String> list = new ArrayList<>();
        generateAll(list, "", n, 0, 0);
        return list;
    }

    public void generateAll(List<String> list, String cur, int max, int left, int right) {
        if (cur.length() == 2 * max) {
            list.add(cur);
            return;
        }
        if (left < max)
            generateAll(list, cur + '(', max, left + 1, right);
        if (right < left)
            generateAll(list, cur + ')', max, left, right + 1);
    }

    /*
     * 方法3：动态规划
     * 枚举左括号 "(" 和右括号 ")" 中间可能的合法的括号对数，
     * 而剩下的合法的括号对数在与第一个左括号 "(" 配对的右括号 ")" 的后面。
     * dp[i] = "(" + dp[j] + ")" + dp[i-j-1]
     */
    public List<String> generateParentheses3(int n) {
        // dp存储i对括号对应的字符串列表
        ArrayList<List<String>> dp = new ArrayList<>(n);
        // 需要用到0对括号的字符串列表
        ArrayList<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        // 使用状态转移方程获取n对括号的状态
        for (int i = 1; i <= n; i++) {
            ArrayList<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> list1 = dp.get(i - j - 1);
                List<String> list2 = dp.get(j);
                for (String str1 : list1) {
                    for (String str2 : list2) {
                        cur.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
