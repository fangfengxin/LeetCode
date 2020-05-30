package May.problem_0084_LargestRectangleInHistogram;

/*
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */

import java.util.ArrayDeque;

/**
 * @Author hustffx
 * @Date 2020/5/30 14:20
 */
public class LargestRectangleInHistogram {
    /**
     * 方法：单调栈
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }
}
