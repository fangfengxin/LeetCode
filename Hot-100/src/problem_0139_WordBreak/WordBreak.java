package problem_0139_WordBreak;

import java.util.List;

/*
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    /**
     * 方法1：递归回溯
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private boolean wordBreak(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))
                    && wordBreak(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2：记忆化回溯
     * 我们会对相同的字符串调用多次回溯函数。
     * 为了避免这种情况，我们可以使用记忆化的方法，
     * 其中一个 memo 数组会被用来保存子问题的结果。
     * 每当访问到已经访问过的后缀串，
     * 直接用 memo 数组中的值返回而不需要继续调用函数。
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, List<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))
                    && wordBreak(s, wordDict, end, memo)) {
                memo[start] = true;
                break;
            }
        }
        if (memo[start] == null) {
            memo[start] = false;
        }
        return memo[start];
    }

    /**
     * 方法3：动态规划
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串总是字典的一部分
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
