package problem_0406_QueueReconStructionByHeight;

/*
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author hustffx
 * @Date 2020/4/19 13:21
 */
public class QueueReconstructionByHeight {
    /**
     * 方法：排序 + 贪心算法
     * 根据逆序数序列恢复原序列，只需按逆序数序列以原排列数从大到小顺序构建原排列即可。
     * 在本题中如何恢复原排列：
     * 1. 先按高度降序排序，同高度按逆序数升序排序。
     * 2. 按定义，将每个元素插入到逆序数位置即可。
     * 核心思想：
     * 高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][2]);
    }
}
