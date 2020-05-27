package May.problem_0974_SubarraySumsDivisibleByK;

/*
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/5/27 10:15
 */
public class SubarraySumsDivisibleByK {
    /**
     * 方法1：前缀和的正余数 + 哈希表 + 逐一统计
     */
    public int subarraysDivByK1(int[] A, int K) {
        // 哈希表存储余数出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : A) {
            sum += num;

            // 计算同余出现的次数
            int residue = (sum % K + K) % K;
            int same = map.getOrDefault(residue, 0);

            count += same;
            map.put(residue, same + 1);
        }

        return count;
    }

    /**
     * 方法2：前缀和的正余数 + 哈希表 + 单次统计
     */
    public int subarraysDivByK2(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int num : A) {
            sum += num;
            int residue = (sum % K + K) % K;
            map.put(residue, map.getOrDefault(residue, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            count += value * (value - 1) / 2;
        }

        return count;
    }

    /**
     * 方法3：使用数组来代替哈希表，提高效率
     */
    public int subarraysDivByK3(int[] A, int K) {
        int[] record = new int[K];
        record[0]++;

        int sum = 0;
        for (int num : A) {
            sum += num;
            int residue = (sum % K + K) % K;
            record[residue]++;
        }

        int count = 0;
        for (int i : record) {
            count += i * (i - 1) / 2;
        }

        return count;
    }
}
