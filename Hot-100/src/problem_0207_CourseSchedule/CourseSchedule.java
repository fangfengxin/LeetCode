package problem_0207_CourseSchedule;

/*
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse - 1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 提示：
 *   1. 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 *   2. 你可以假定输入的先决条件中没有重复的边。
 *   3. 1 <= numCourses <= 10^5
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hustffx
 */
public class CourseSchedule {
    /**
     * 方法1：使用入度表完成拓扑排序
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 入度表
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 始终存储入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // BFS 拓扑排序
        while (!queue.isEmpty()) {
            // 每次出队，课程量减 1
            int preCourse = queue.poll();
            numCourses--;
            for (Integer course : adjacency.get(preCourse)) {
                // preCourse 对应的所有邻接节点的入度减 1
                indegrees[course]--;
                // 入度变为 0 代表先决课程均正常学习
                if (indegrees[course] == 0) {
                    queue.add(course);
                }
            }
        }
        // 若课程安排图中存在环，一定有节点的入度始终不为 0，导致出队次数不等于课程数量
        return numCourses == 0;
    }

    /**
     * 方法2：深度优先遍历
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 标志列表，0 表示未被访问过，-1 表示已经被其他节点访问，1 表示已被当前节点启动
        int[] flags = new int[numCourses];
        // 依次深度优先搜索每个课程开始是否有环
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先搜索检测是否存在环
     */
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 已被当前节点访问过，即存在环
        if (flags[i] == 1) {
            return true;
        }
        // 已被其他节点访问过，说明后续无环，则判断无环
        if (flags[i] == -1) {
            return false;
        }
        // 未曾被访问过
        // 标记为当前节点访问
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            // 邻接节点之后存在环
            if (dfs(adjacency, flags, j)) {
                return true;
            }
        }
        // 当前节点开始没有环
        flags[i] = -1;
        return false;
    }
}
