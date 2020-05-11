package problem_0155_MinStack;

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

import java.util.Stack;

/**
 * 使用辅助栈建立最小栈
 */
public class MinStackWithAuxiliaryStack {
    /**
     * 数据栈
     */
    private final Stack<Integer> stack;
    /**
     * 辅助存储最小值的栈
     */
    private final Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStackWithAuxiliaryStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 将元素 x 推入栈中。
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            // 入栈元素小于等于当前最小栈顶时
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    /**
     * 删除栈顶的元素。
     */
    public void pop() {
        int pop = stack.pop();
        // 出栈元素等于最小栈顶时
        if (pop == minStack.peek()) {
            minStack.pop();
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
        return minStack.peek();
    }
}
