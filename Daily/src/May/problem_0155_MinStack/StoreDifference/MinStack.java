package May.problem_0155_MinStack.StoreDifference;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author hustffx
 * @Date 2020/5/12 0:27
 */
public class MinStack {
    /**
     * 数据栈，存储当前值与最小值的差值。
     */
    private final Deque<Long> stack;
    /**
     * 当前最小值。
     */
    private long min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = 0;
    }

    /**
     * 将元素 x 推入栈中。
     *
     * @param x
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push((long) 0);
            min = x;
        } else {
            stack.push((long) (x - min));
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
        long pop = stack.pop();
        // 弹出的是负值，要更新 min
        if (pop < 0) {
            min -= pop;
        }
    }

    /**
     * 获取栈顶元素。
     */
    public int top() {
        long top = stack.peek();
        // 注意栈顶元素正负性对计算真实元素值的影响
        return (int) (top > 0 ? min + top : min);
    }

    /**
     * 检索栈中的最小元素。
     */
    public int getMin() {
        return (int) min;
    }
}
