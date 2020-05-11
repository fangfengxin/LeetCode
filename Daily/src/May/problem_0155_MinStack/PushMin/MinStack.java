package May.problem_0155_MinStack.PushMin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author hustffx
 * @Date 2020/5/12 0:12
 */
public class MinStack {
    /**
     * 数据栈，每次更新最小值之前将上一个最小值入栈。
     */
    private final Deque<Integer> stack;
    /**
     * 当前最小值
     */
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
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
