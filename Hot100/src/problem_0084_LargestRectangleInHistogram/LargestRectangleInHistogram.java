package problem_0084_LargestRectangleInHistogram;

import java.util.Stack;

/*
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleInHistogram {
    /*
     * 方法1：暴力破解
     */
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    /*
     * 方法2：分治
     * 最大面积矩形存在于以下几种情况：
     * 1.确定了最矮柱子以后，矩形的宽尽可能往两边延伸。
     * 2.在最矮柱子左边的最大面积矩形（子问题）。
     * 3.在最矮柱子右边的最大面积矩形（子问题）。
     */
    public int largestRectangleArea2(int[] heights) {
        return calculatorArea(heights, 0, heights.length - 1);
    }

    private int calculatorArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return Math.max(
                heights[minIndex] * (end - start + 1),
                Math.max(calculatorArea(heights, start, minIndex - 1),
                        calculatorArea(heights, minIndex + 1, end))
        );
    }

    /*
     * 方法3：栈
     */
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
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
