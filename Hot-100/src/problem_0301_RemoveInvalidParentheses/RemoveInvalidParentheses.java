package problem_0301_RemoveInvalidParentheses;

/*
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 *
 * 示例 2:
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 *
 * 示例 3:
 * 输入: ")("
 * 输出: [""]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    /**
     * 方法：回溯
     */
    public List<String> removeInvalidParentheses(String s) {
        // 记录要删除的左括号数量
        int leftToDelete = 0;
        // 记录要删除的右括号数量
        int rightToDelete = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToDelete++;
            } else if (c == ')') {
                if (leftToDelete > 0) {
                    leftToDelete--;
                } else {
                    rightToDelete++;
                }
            }
        }
        // 存储有效的结果集
        HashSet<String> set = new HashSet<>();
        dfs(s, 0, 0, leftToDelete, rightToDelete, set, new StringBuilder());
        return new ArrayList<>(set);
    }

    /**
     * 回溯求所有的有效结果集
     *
     * @param s
     * @param index
     * @param leftCount
     * @param leftToDelete
     * @param rightToDelete
     * @param set
     * @param sb
     */
    private void dfs(String s, int index, int leftCount, int leftToDelete,
                     int rightToDelete, HashSet<String> set, StringBuilder sb) {
        if (index == s.length()) {
            if (leftToDelete == 0 && rightToDelete == 0 && leftCount == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            // 如果是左括号，要么删除，要么保留
            // 如果删除
            if (leftToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete - 1, rightToDelete, set, tmp);
            }
            // 如果不删，或者没有可删除的
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount + 1, leftToDelete, rightToDelete, set, tmp);
        } else if (c == ')') {
            // 如果是右括号，要么删除，要么在前面有左括号的时候保留，否则只能删除
            if (rightToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete, rightToDelete - 1, set, tmp);
            }
            if (leftCount > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(c);
                dfs(s, index + 1, leftCount - 1, leftToDelete, rightToDelete, set, tmp);
            }
        } else {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount, leftToDelete, rightToDelete, set, tmp);
        }
    }
}
