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
 * 存储与当前最小值的差值
 * 差值可能会有数值溢出，使用 long 类型
 */
public class MinStackByStoringDifference {
    Stack<Long> stack;
    long min;

    /**
     * initialize your data structure here.
     */
    public MinStackByStoringDifference() {
        stack = new Stack<>();
        min = 0;
    }

    /**
     * 将元素 x 推入栈中。
     *
     * @param x
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
            // 与当前 min 的差值入栈后再更新 min
            if (x < min) {
                min = x;
            }
        }
    }

    /**
     * 删除栈顶的元素。
     */
    public void pop() {
        Long pop = stack.pop();
        // 弹出的是负值，要更新 min
        if (pop < 0) {
            min = min - pop;
        }
    }

    /**
     * 获取栈顶元素。
     */
    public int top() {
        Long top = stack.peek();
        // top 为负数时，元素值就是当前 min
        // top 不为负时，真实值为 top + min
        return top < 0 ? (int) min : (int) (top + min);
    }

    /**
     * 检索栈中的最小元素。
     */
    public int getMin() {
        return (int) min;
    }
}
