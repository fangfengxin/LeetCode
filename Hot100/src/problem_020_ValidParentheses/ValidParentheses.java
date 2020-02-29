package problem_020_ValidParentheses;

import java.util.*;

/*
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
 * 判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.equals("")) return true;
        LinkedList<Character> list = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) { // 是左括号则压栈
                list.push(ch);
            } else if (list.isEmpty()) { // 是右括号且栈为空
                return false;
            } else if (list.pop() != map.get(ch)) { // 是右括号且栈不为空且匹配失败
                return false;
            }
        }
        return list.isEmpty();
    }
}
