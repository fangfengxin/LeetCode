package problem_0155_MinStack;

import java.util.Stack;

/*
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，
 * 并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

/**
 * 将上一个最小值入栈后再更新最小值
 */
public class MinStackByPushingMin {
    Stack<Integer> stack;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStackByPushingMin() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /**
     * 将元素 x 推入栈中。
     *
     * @param x
     */
    public void push(int x) {
        // 当前值小于最小值
        if (x <= min) {
            // 之前的最小值入栈
            stack.push(min);
            // 更新最小值
            min = x;
        }
        // 当前元素入栈
        stack.push(x);
    }

    /**
     * 删除栈顶的元素。
     */
    public void pop() {
        int pop = stack.pop();
        // 出栈元素等于当前最小值
        if (pop == min) {
            // 下一个出栈元素就是之前的最小值
            min = stack.pop();
        }
    }

    /**
     * 获取栈顶元素。
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 检索栈中的最小元素。
     */
    public int getMin() {
        return min;
    }
}
