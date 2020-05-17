package May.problem_0210_CourseScheduleII;

/*
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 说明:
 * 1. 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 2. 你可以假定输入的先决条件中没有重复的边。
 *
 * 提示:
 * 1. 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 2. 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 3. 拓扑排序也可以通过 BFS 完成。
 */

import java.util.*;

/**
 * @Author hustffx
 * @Date 2020/5/17 11:35
 */
public class CourseScheduleII {
    /**
     * 方法1：DFS实现的拓扑排序
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        // 使用栈来记录访问顺序，根据FILO的特点，后续课程先入栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 使用数组记录访问状态，0=未访问过，1=已被当前节点启动，-1=已经被其他节点访问
        int[] visited = new int[numCourses];

        // 使用列表数组来存储有向图的邻接表
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        // 建立邻接表
        for (int[] pre : prerequisites) {
            edges[pre[1]].add(pre[0]);
        }

        // DFS实现拓扑排序
        for (int i = 0; i < numCourses; i++) {
            if (dfs(edges, visited, stack, i)) {
                return new int[0];
            }
        }

        // 将拓扑排序结果转换为数组
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    /**
     * 深度优先搜索有向图，检测是否有环，并记录访问顺序。
     *
     * @param edges
     * @param visited
     * @param stack
     * @param i
     * @return
     */
    private boolean dfs(List<Integer>[] edges, int[] visited, Deque<Integer> stack, int i) {
        // 当前节点已经被当前节点访问过，即存在环
        if (visited[i] == 1) {
            return true;
        }

        // 当前节点已经被其他节点访问，说明后续无环
        if (visited[i] == -1) {
            return false;
        }

        // 标记为正在访问
        visited[i] = 1;

        // 访问邻接节点
        for (Integer p : edges[i]) {
            if (dfs(edges, visited, stack, p)) {
                return true;
            }
        }

        // 标记为已访问
        visited[i] = -1;
        stack.push(i);

        return false;
    }

    /**
     * 方法2：BFS利用入度实现拓扑排序
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        // 利用哈希表存储邻接表
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        // 利用数组存储入度表
        int[] inDegree = new int[numCourses];
        // 拓扑排序结果数组
        int[] topologicalOrder = new int[numCourses];
        // 使用队列进行入度为0的节点访问
        Queue<Integer> queue = new LinkedList<>();

        // 建立邻接表和入度表
        for (int[] pre : prerequisites) {
            List<Integer> list = edges.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            edges.put(pre[1], list);

            inDegree[pre[0]]++;
        }

        // 把入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        // BFS拓扑排序
        while (!queue.isEmpty()) {
            // 访问入度为0的节点，将节点从队列中弹出并加入结果集
            int preCourse = queue.poll();
            topologicalOrder[index++] = preCourse;

            // 当前访问节点的邻接节点入度改变
            if (edges.containsKey(preCourse)) {
                for (Integer course : edges.get(preCourse)) {
                    inDegree[course]--;

                    // 邻接节点的入度已经减为0，则可以被访问了
                    if (inDegree[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
        }

        // 判断是否所有节点均已访问
        if (index == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
