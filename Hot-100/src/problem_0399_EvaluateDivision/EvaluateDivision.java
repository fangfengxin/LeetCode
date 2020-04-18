package problem_0399_EvaluateDivision;

/*
 * 399. 除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
 * 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为:
 * vector<pair<string, string>> equations,
 * vector<double>& values,
 * vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)，
 * 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），
 * 并且结果值均为正数。以上为方程式的描述。 返回 vector<double> 类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/4/18 12:54
 */
public class EvaluateDivision {
    /**
     * 存储当前节点的父节点
     */
    private final Map<String, String> parentMap = new HashMap<>();
    /**
     * 存储当前节点的父节点除以当前节点的商
     */
    private final Map<String, Double> valueMap = new HashMap<>();

    /**
     * 方法1：并查集
     */
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 初始化并查集
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            union(equation.get(0), equation.get(1), values[i]);
        }
        // 结果数组
        double[] res = new double[queries.size()];
        // 使用并查集查询结果并进行存储
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            // 含有未知数
            if (!parentMap.containsKey(a) || !parentMap.containsKey(b)) {
                res[i] = -1;
                continue;
            }
            // 被除数与除数一样
            if (a.equals(b)) {
                res[i] = 1;
                continue;
            }
            // 寻找两个节点的根节点
            String p1 = find(a);
            String p2 = find(b);
            // 根节点相同，计算，根节点不同，则不连通，无法计算结果
            res[i] = p1.equals(p2) ? valueMap.get(b) / valueMap.get(a) : -1;
        }
        return res;
    }

    /**
     * 向并查集中添加节点
     *
     * @param x
     */
    private void add(String x) {
        // 如果已经存在则不处理
        if (parentMap.containsKey(x)) {
            return;
        }
        parentMap.put(x, x);
        valueMap.put(x, 1.0);
    }

    /**
     * 在并查集中寻找节点的根节点，同时更新节点值
     *
     * @param x
     * @return
     */
    private String find(String x) {
        String root = x;
        double value = 1;
        while (!parentMap.get(root).equals(root)) {
            value *= valueMap.get(root);
            root = parentMap.get(root);
        }
        parentMap.put(x, root);
        valueMap.put(x, value);
        return root;
    }

    /**
     * 将两个节点连接起来
     *
     * @param x1
     * @param x2
     * @param value
     */
    private void union(String x1, String x2, double value) {
        // 将节点添加到并查集中
        add(x1);
        add(x2);
        // 找到节点的根节点
        String p1 = find(x1);
        String p2 = find(x2);
        // 两个根节点一致则不处理
        if (p1.equals(p2)) {
            return;
        }
        // 将x2的根节点的父节点设置为x1的根节点
        parentMap.put(p2, p1);
        valueMap.put(p2, value * valueMap.get(x1) / valueMap.get(x2));
    }

    /**
     * 方法2：图 + DFS
     */
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 建立双向图
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            map.computeIfAbsent(equation.get(0), k -> new HashMap<>()).put(equation.get(1), values[i]);
            map.computeIfAbsent(equation.get(1), k -> new HashMap<>()).put(equation.get(0), 1 / values[i]);
        }
        // 结果数组
        double[] res = new double[queries.size()];
        // DFS
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), 1, map, new ArrayList<>());
        }
        return res;
    }

    private double dfs(String src, String dst, double value, Map<String, Map<String, Double>> map, List<String> visited) {
        // 当前节点加入已访问列表
        visited.add(src);
        Map<String, Double> neighbor = map.get(src);
        // 没有路径可寻，返回 -1
        if (neighbor == null) {
            return -1;
        }
        // 遍历当前节点的下一节点，逐一递归
        for (Map.Entry<String, Double> entry : neighbor.entrySet()) {
            String entryKey = entry.getKey();
            double entryValue = entry.getValue();
            // 找到目的节点，返回对应的值
            if (dst.equals(entryKey)) {
                return value * entryValue;
            }
            // 当前节点已经访问过就不再访问
            if (visited.contains(entryKey)) {
                continue;
            }
            double res = dfs(entryKey, dst, value * entryValue, map, visited);
            // 有路径已找到结果，直接返回，不再寻找，否则继续遍历
            if (res > 0) {
                return res;
            }
        }
        // 没找到路径，返回 -1
        return -1;
    }
}
