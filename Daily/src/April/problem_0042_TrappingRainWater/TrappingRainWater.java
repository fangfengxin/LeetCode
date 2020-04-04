package April.problem_0042_TrappingRainWater;

import java.util.Stack;

/*
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrappingRainWater {
    /**
     * 方法1：栈
     */
    public int trap1(int[] height) {
        int res = 0;
        int curIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (curIndex < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[curIndex]) {
                // 形成 高-矮-高 形状储水
                int midHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int boundMinHeight = Math.min(height[curIndex], height[stack.peek()]);
                int distance = curIndex - stack.peek() - 1;
                res += distance * (boundMinHeight - midHeight);
            }
            stack.push(curIndex);
            curIndex++;
        }
        return res;
    }

    /**
     * 方法2：动态规划
     * 左边的最高柱子可以使用一个变量存储使用，右边需要逆序遍历，所以用数组。
     */
    public int trap2(int[] height) {
        int res = 0;
        int left = 0;
        int[] right = new int[height.length];
        // 反向遍历求所有柱子右边的最高柱子
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        // 正向遍历求储水量
        for (int i = 1; i < height.length - 1; i++) {
            left = Math.max(left, height[i - 1]);
            int boundHeight = Math.min(left, right[i]);
            if (boundHeight > height[i]) {
                res += boundHeight - height[i];
            }
        }
        return res;
    }

    /**
     * 方法3：双指针
     * 只要保证 height[left - 1] < height[right + 1]，那么 leftMax < rightMax
     * 反之则是 leftMax > rightMax
     */
    public int trap3(int[] height) {
        int res = 0;
        int left = 1;
        int leftMax = 0;
        int right = height.length - 2;
        int rightMax = height[height.length - 1];
        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(leftMax, height[left - 1]);
                if (leftMax > height[left]) {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right + 1]);
                if (rightMax > height[right]) {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
