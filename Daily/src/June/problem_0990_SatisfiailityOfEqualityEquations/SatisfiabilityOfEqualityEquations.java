package June.problem_0990_SatisfiailityOfEqualityEquations;

/*
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
 * 在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 *
 * 示例 2：
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 *
 * 示例 3：
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 * 提示：
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 */

/**
 * @Author hustffx
 * @Date 2020/6/8 11:15
 */
public class SatisfiabilityOfEqualityEquations {
    /**
     * 方法：并查集
     */
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();

            if (charArray[1] == '=') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';

                unionFind.union(index1, index2);
            }
        }

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();

            if (charArray[1] == '!') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';

                // 如果在一个连通集，表示等式有矛盾，根据题意，返回false
                if (unionFind.isConnected(index1, index2)) {
                    return false;
                }
            }
        }

        // 如果检查所有方程式，都没有发现矛盾，返回true
        return true;
    }

    /**
     * 定义并查集
     */
    private class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 查找根节点
         *
         * @param x
         * @return
         */
        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩（隔代压缩）
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        /**
         * 合并连通集
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        /**
         * 检查是否连通
         *
         * @param x
         * @param y
         * @return
         */
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
