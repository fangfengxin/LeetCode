package problem_0017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinationsOfAPhoneNumber {
    /*
     * 回溯算法
     */
    private HashMap<Character, String> map = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    ArrayList<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return output;
        combine("", digits);
        return output;
    }

    public void combine(String combination, String left_digits) {
        if (left_digits.length() == 0) {
            output.add(combination);
            return;
        }
        char c = left_digits.charAt(0);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            combine(combination + str.charAt(i), left_digits.substring(1));
        }
    }
}
