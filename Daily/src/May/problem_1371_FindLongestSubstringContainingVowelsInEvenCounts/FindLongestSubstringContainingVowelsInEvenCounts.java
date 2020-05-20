package May.problem_1371_FindLongestSubstringContainingVowelsInEvenCounts;

/*
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 * 示例 1：
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 * 示例 2：
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 *
 * 示例 3：
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *
 * 提示：
 * 1. 1 <= s.length <= 5 x 10^5
 * 2. s 只包含小写英文字母。
 */

import java.util.Arrays;

/**
 * @Author hustffx
 * @Date 2020/5/20 19:08
 */
public class FindLongestSubstringContainingVowelsInEvenCounts {
    /**
     * 方法：前缀和 + 状态压缩
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int res = 0;

        /*
         * 压缩的状态值
         * 表示当前索引位置的前缀中uoiea五个元音出现次数分别是奇数或偶数的状态
         * [00000(0), 11111(31)]
         */
        int status = 0;

        // 存储各种前缀情况首次出现的索引
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        // 索引0的前缀状态就是0
        pos[0] = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 计算状态值
            switch (c) {
                case 'a':
                    status ^= (1 << 0);
                    break;
                case 'e':
                    status ^= (1 << 1);
                    break;
                case 'i':
                    status ^= (1 << 2);
                    break;
                case 'o':
                    status ^= (1 << 3);
                    break;
                case 'u':
                    status ^= (1 << 4);
                    break;
                default:
            }

            // 当前状态已经出现过，则计算距离，否则存储当前前缀状态对应的索引值
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }

        return res;
    }
}
