package April.problem_0466_CountRepetitions;

/*
 * 466. 统计重复个数
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 10^6 和 1 ≤ n2 ≤ 10^6。
 * 现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 *
 * 示例：
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 * 返回：2
 */

import java.util.HashMap;

/**
 * @Author hustffx
 * @Date 2020/4/19 11:04
 */
public class CountRepetitions {
    /**
     * 方法：寻找循环节
     * 尽可能的找出循环来减少遍历的次数。
     * 假设我们遍历了 s1cnt 个 s1，此时匹配到了第 s2cnt 个 s2 中的第 index 个字符
     * 如果我们之前遍历了 s1cnt' 个 s1 时，匹配到的是第 s2cnt' 个 s2 中同样的第 index 个字符，那么就有循环节了
     * 我们用 (s1cnt', s2cnt', index) 和 (s1cnt, s2cnt, index) 表示两次包含相同 index 的匹配结果
     * 那么哈希映射中的键就是 index，值就是 (s1cnt', s2cnt') 这个二元组
     * 循环节就是；
     * - 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
     * - 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
     * 那么还会剩下 (n1 - s1cnt') % (s1cnt - s1cnt') 个 s1, 我们对这些与 s2 进行暴力匹配
     * 注意 s2 要从第 index 个字符开始匹配
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 转换为字符数组，提高匹配效率
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // 遍历的s1的数量
        int count1 = 0;
        // 遍历的s2的数量
        int count2 = 0;
        // s2的下标
        int index = 0;
        // 哈希表以s2下标index为索引，存储匹配到第count1个s1的末尾和第count2个s2的第index个字符时，已经匹配过的s1和s2的个数count1和count2
        HashMap<Integer, int[]> map = new HashMap<>();
        // 一个循环节中s1的数量
        int circle1 = 0;
        // 一个循环节中s2的数量
        int circle2 = 0;
        // 无论循环是否找到，字符串没遍历完，就要继续匹配
        while (count1 < n1) {
            for (int i = 0; i < len1; i++) {
                // 匹配到一个字符，s2下标加1
                if (c1[i] == c2[index]) {
                    index++;
                    // s2遍历完，从头继续，count2加1
                    if (index == len2) {
                        index = 0;
                        count2++;
                    }
                }
            }
            // s1遍历完一次，count1加1
            count1++;
            if (!map.containsKey(index)) {
                // 当前状态不存在则记录
                map.put(index, new int[]{count1, count2});
            } else if (circle1 == 0) {
                // 当前状态存在，计算循环节信息
                int[] lastCount = map.get(index);
                circle1 = count1 - lastCount[0];
                circle2 = count2 - lastCount[1];
                // 更新count1和count2到循环截止位置
                count2 += (n1 - count1) / circle1 * circle2;
                count1 += (n1 - count1) / circle1 * circle1;
            }
        }
        return count2 / n2;
    }
}
