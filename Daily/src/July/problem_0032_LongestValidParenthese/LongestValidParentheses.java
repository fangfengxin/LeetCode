package July.problem_0032_LongestValidParenthese;

/*
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author hustffx
 * @Date 2020/7/4 10:36
 */
public class LongestValidParentheses {
    /**
     * 方法1：动态规划
     */
    public int longestValidParentheses1(String s) {
        int maxLen = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = 2 + (i > 1 ? dp[i - 2] : 0);
                } else {
                    int j = i - dp[i - 1] - 1;

                    if (j >= 0 && chars[j] == '(') {
                        dp[i] = 2 + dp[i - 1] + (j > 0 ? dp[j - 1] : 0);
                    }
                }

                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }

    /**
     * 方法2：栈
     */
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        return maxLen;
    }

    /**
     * 方法3：正向逆向结合法
     */
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        int n = s.length();
        char[] chars = s.toCharArray();

        // 记录左右括号个数
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (left < right) {
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }
}
