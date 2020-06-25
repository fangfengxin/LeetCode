package June.problem_0139_WordBreak;

import java.util.HashSet;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/25 11:21
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> wordDictSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
