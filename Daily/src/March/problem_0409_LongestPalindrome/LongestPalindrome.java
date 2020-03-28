package March.problem_0409_LongestPalindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:假设字符串的长度不会超过 1010。
 *
 * 示例:
 * 输入:"abccccdd"
 * 输出:7
 * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    /*
     * 方法1：字符计数
     */
    public int longestPalindrome1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (char c : map.keySet()) {
            int count = map.get(c);
            res += count / 2 * 2;
            if (count % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    /*
     * 方法2：流式编程
     */
    public int longestPalindrome2(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int res = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return res < s.length() ? res + 1 : res;
    }
}
