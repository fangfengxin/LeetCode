package April.problem_0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParentheses {
    /**
     * 方法：回溯算法
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis("", 0, 0, n, res);
        return res;
    }

    /**
     * 通过回溯获得所有的括号字符串
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经使用的个数
     * @param right  右括号已经使用的个数
     * @param max    最大括号对数
     * @param res    结果集
     */
    private void generateParenthesis(String curStr, int left, int right, int max, List<String> res) {
        if (curStr.length() == 2 * max) {
            res.add(curStr);
            return;
        }
        if (left < max) {
            generateParenthesis(curStr + '(', left + 1, right, max, res);
        }
        if (right < left) {
            generateParenthesis(curStr + ')', left, right + 1, max, res);
        }
    }
}
