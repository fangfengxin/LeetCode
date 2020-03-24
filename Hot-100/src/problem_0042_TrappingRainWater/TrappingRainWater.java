package problem_0042_TrappingRainWater;

import java.util.Stack;

/*
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrappingRainWater {
    /*
     * 方法1：按行求
     * 求第 i 层的水，遍历每个位置，如果当前的高度小于 i，并且两边有高度大于等于 i 的，说明这个地方一定有水，水就可以加 1。
     */
    public int trap1(int[] height) {
        int sum = 0; // 总的雨水量
        int max = 0; // 最大高度
        for (int value : height) {
            if (max < value) {
                max = value;
            }
        }
        // 从第1行开始求每行的雨水量
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; // 标记是否开始更新tmp
            int tmp = 0; // 当前行的雨水量
            for (int j = 0; j < height.length; j++) {
                // 遇到高度大于等于 i 的时候，开始更新 temp
                // 更新原则：遇到高度小于 i 就将 tmp 加 1，遇到高度大于等于 i 的就将 tmp 加到 sum 中并置零，新一轮更新tmp
                if (height[j] >= i) {
                    sum += tmp; // 不在循环结束后再更新 sum，是因为每行最后一个达到高度 i 之后的部分实际上没有雨水存储。
                    tmp = 0;
                    isStart = true;
                } else if (isStart) {
                    tmp++;
                }
            }
        }
        return sum;
    }

    /*
     * 方法2：按列求
     * 遍历每一列，然后分别求出这一列两边最高的柱子。
     * 找出较矮的一端，和当前列的高度比较，有两种情况：
     * 1.较矮的柱子的高度大于当前柱子的高度，可以储水；
     * 2.较矮的柱子的高度小于等于当前柱子的高度，无法储水。
     */
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 找到左边最高的柱子
            int left = 0;
            for (int j = 0; j < i; j++) {
                if (left < height[j]) {
                    left = height[j];
                }
            }
            // 找到右边最高的柱子
            int right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (right < height[j]) {
                    right = height[j];
                }
            }
            // 找出两端较矮的柱子
            int min = Math.min(left, right);
            // 只有较矮的柱子高于当前柱子，才会储水
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /*
     * 方法3：动态规划
     * 方法2中，求每一列左边最高的柱子和右边最高的柱子，都是重新遍历一遍所有高度，可以使用动态规划优化。
     * 左边的最高柱子可以使用一个变量存储使用，右边需要逆序遍历，所以用数组。
     */
    public int trap3(int[] height) {
        int sum = 0;
        int left = 0;
        int[] right = new int[height.length];
        // 求所有柱子右边的最高柱子
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        // 遍历数组求储水量
        for (int i = 1; i < height.length - 1; i++) {
            left = Math.max(left, height[i - 1]);
            int min = Math.min(left, right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /*
     * 方法4：双指针
     * 方法3中动态规划最后的结果只是去掉了left数组，因为数组是从左往右遍历的。
     * 如果想把right数组也去掉，那么需要使用left和right两个指针来从两个方向遍历。
     */
    public int trap4(int[] height) {
        int sum = 0;
        int left_max = 0, right_max = 0;
        int left = 1, right = height.length - 2; // 左右遍历的指针
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                left_max = Math.max(left_max, height[left - 1]);
                if (left_max > height[left]) {
                    sum += left_max - height[left];
                }
                left++;
            } else {
                right_max = Math.max(right_max, height[right + 1]);
                if (right_max > height[right]) {
                    sum += right_max - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    /*
     * 方法5：栈
     * 用栈保存每根柱子。当遍历柱子的高度的时候，如果当前高度小于栈顶的柱子高度，说明这里会有积水，我们将柱子的高度的下标入栈。
     * 如果当前高度大于栈顶的柱子的高度，说明之前的积水到这里停下，可以计算有多少积水。计算完，就把当前的柱子继续入栈，作为新的积水的柱子。
     * 总体的原则是：
     * 1.当前高度小于等于栈顶高度，入栈，指针后移。
     * 2.当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     */
    public int trap5(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length) {
            // 栈不为空且当前高度大于栈顶高度
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()]; // 栈顶出栈，取其高度
                if (stack.isEmpty()) { // 栈空则表示没有柱子可以积水，结束当前循环
                    break;
                }
                // 计算积水量，当前元素和栈顶元素对应两端的柱子
                int distance = cur - stack.peek() - 1; // 当前柱子与当前栈顶的距离
                int min = Math.min(height[cur], height[stack.peek()]); // 当前高度与栈顶高度的最小值
                sum += (min - h) * distance;
            }
            stack.push(cur);
            cur++;
        }
        return sum;
    }
}
