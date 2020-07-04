package problem_0032_LongestValidParentheses;

/*
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

import java.util.Stack;

/**
 * @author hustffx
 */
public class LongestValidParentheses {
    /**
     * 方法1：暴力破解
     * 考虑给定字符串中每种可能的非空偶数长度子字符串，检查它是否是一个有效括号字符串序列
     */
    public int longestValidParentheses1(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 方法2：栈的应用
     * 用一个栈来存储坐标，在最开始的时候，将栈里面放入一个-1，方便计算
     */
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            // 遇到'('将其坐标入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            // 遇到')'弹出栈顶元素
            else {
                stack.pop();
                // 栈非空，又多一对匹配，需要更新max的值
                if (!stack.empty()) {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
                // 栈空，表示前面已经正好匹配后又遇到')',只需将当期坐标入栈，作用与初始的-1相同
                else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }

    /**
     * 方法3：动态规划
     * 定义dp数组存储以当前字符结尾的最长有效字符串长度。
     * 显然，字符'('结尾的字符串不可能是有效字符串，长度必然为0。
     */
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // 遇到')'
            if (s.charAt(i) == ')') {
                // 前一个字符是'('，则在'('之前的匹配基础上+2
                // 前一个字符是')'，则判断与前一个字符匹配的最远'('的前一个字符是不是'('，是则再加上此'('之前的匹配情况
                if (s.charAt(i - 1) == '(') {
                    dp[i] = ((i > 1) ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
