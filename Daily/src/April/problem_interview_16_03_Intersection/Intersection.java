package April.problem_interview_16_03_Intersection;

/*
 * 面试题 16.03. 交点
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 * 示例 1：
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 *
 * 示例 2：
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 *
 * 示例 3：
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 *
 * 提示：
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 */

import java.util.Arrays;

public class Intersection {
    /**
     * 方法1：直线方程
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];

        double[] res = new double[2];
        Arrays.fill(res, Double.MAX_VALUE);

        // 判断两条直线是否平行
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            // 判断两直线是否重叠
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                if (isInside(start1, end1, start2)) {
                    updateRes(res, start2);
                }
                if (isInside(start1, end1, end2)) {
                    updateRes(res, end2);
                }
                if (isInside(start2, end2, start1)) {
                    updateRes(res, start1);
                }
                if (isInside(start2, end2, end1)) {
                    updateRes(res, end1);
                }
            }
        } else {
            // 联立方程得到 t1, t2
            double t1 = (x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) * 1.0 / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) * 1.0 / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1, t2 是否在 [0, 1] 范围内
            if (0 <= t1 && t1 <= 1 && 0 <= t2 && t2 <= 1) {
                res[0] = x1 + t1 * (x2 - x1);
                res[1] = y1 + t1 * (y2 - y1);
            }
        }
        return (res[0] == Double.MAX_VALUE) ? new double[0] : res;
    }

    /**
     * 判断点 point 是否在线段 [start, end] 上
     *
     * @param start 线段起点坐标
     * @param end   线段终点坐标
     * @param point 待判断点的坐标
     */
    private boolean isInside(int[] start, int[] end, int[] point) {
        int x1 = start[0], y1 = start[1];
        int x2 = end[0], y2 = end[1];
        int x = point[0], y = point[1];
        return (x1 == x2 || Math.min(x1, x2) <= x && x <= Math.max(x1, x2)) &&
                (y1 == y2 || Math.min(y1, y2) <= y && y <= Math.max(y1, y2));
    }

    /**
     * 更新结果点的坐标
     */
    private void updateRes(double[] res, int[] point) {
        if (point[0] < res[0] || (point[0] == res[0] && point[1] < res[1])) {
            res[0] = point[0];
            res[1] = point[1];
        }
    }
}
