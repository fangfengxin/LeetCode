package problem_0438_FindAllAnagramsInString;

/*
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 1. 字母异位词指字母相同，但排列不同的字符串。
 * 2. 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/4/19 17:59
 */
public class FindAllAnagramsInString {
    /**
     * 方法：滑动窗口 + 双指针
     * 使用数组代替哈希表进行存储
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        // 存储字符串p中每个字符的数量
        int[] letters = new int[26];
        for (char c : p.toCharArray()) {
            letters[c - 'a']++;
        }

        // 滑动窗口中的字符分布
        int[] window = new int[26];
        // 双指针
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            window[chars[right] - 'a']++;
            right++;

            if (right - left < p.length()) {
                continue;
            }

            /*if (Arrays.equals(letters, window)) {
                res.add(left);
            }*/

            if (isSame(letters, window)) {
                res.add(left);
            }

            window[chars[left] - 'a']--;
            left++;
        }

        return res;
    }

    private boolean isSame(int[] letters, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (letters[i] != window[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法：滑动窗口 + 双指针
     * 原理不变，加入匹配情况筛选，优化效率
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        // 存储字符串p中每个字符的数量
        int[] letters = new int[26];
        // 包含多少种字符
        int numLetter = 0;
        for (char c : p.toCharArray()) {
            int i = c - 'a';
            letters[i]++;
            if (letters[i] == 1){
                numLetter++;
            }
        }

        // 滑动窗口中的字符分布
        int[] window = new int[26];
        // 双指针
        int left = 0;
        int right = 0;
        // 记录已经匹配的字符数量
        int match = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            int c1 = chars[right] - 'a';
            if (letters[c1] > 0) {
                window[c1]++;
                if (window[c1] == letters[c1]) {
                    match++;
                }
            }
            right++;

            while (match == numLetter) {
                // 如果窗口大小匹配，就将当前起始索引加入结果列表
                if (right - left == p.length()) {
                    res.add(left);
                }

                int c2 = chars[left] - 'a';
                if (letters[c2] > 0) {
                    window[c2]--;
                    if (window[c2] < letters[c2]) {
                        match--;
                    }
                }
                left++;
            }
        }

        return res;
    }
}
