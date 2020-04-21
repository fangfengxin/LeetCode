package problem_0621_TaskScheduler;

/*
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的 26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 ：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 * 提示：
 * 1. 任务的总个数为 [1, 10000]。
 * 2. n 的取值范围为 [0, 100]。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author hustffx
 * @Date 2020/4/21 18:07
 */
public class TaskScheduler {
    /**
     * 方法1：排序
     * 规定 n + 1 个任务为一轮，这样的好处是同一轮中一个任务最多只能被安排一次。
     * 在每一轮中，我们将当前的任务按照它们剩余的次数降序排序，并选择剩余次数最多的 n + 1 个任务依次执行。
     * 如果任务的种类 t 少于 n + 1 个，就只选择全部的 t 种任务，其余的时间空闲。
     * 这样做的正确性在于，由于冷却时间的存在，出现次数较多的那些任务如果不尽早安排，将会导致大量空闲时间的出现，
     * 因此贪心地将出现次数较多的任务安排在前面是合理的。同时我们可以保证，这一轮的第 k 个任务距离上一次执行至少有 n 个单位的冷却时间。
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int time = 0;
        while (count[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (count[25] == 0) {
                    break;
                }
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(count);
        }
        return time;
    }

    /**
     * 方法2：优先队列
     * 用优先队列（堆）来代替排序
     */
    public int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, (o1, o2) -> o2 - o1);
        for (int i : count) {
            if (i > 0) {
                queue.offer(i);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        list.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;
                if (queue.isEmpty() && list.size() == 0) {
                    break;
                }
                i++;
            }
            for (Integer task : list) {
                queue.offer(task);
            }
        }
        return time;
    }

    /**
     * 方法3：设计
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     * 如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     * 则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下任务的总数就是最小所需时间
     */
    public int leastInterval3(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int maxCount = count[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        while (i >= 0 && count[i] == maxCount) {
            retCount++;
            i--;
        }
        return Math.max(retCount, tasks.length);
    }
}
