package May.problem_0155_MinStack.PushMin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/12 0:25
 */
class MinStackTest {
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(minStack.getMin(), -3);
        minStack.pop();
        assertEquals(minStack.top(), 0);
        assertEquals(minStack.getMin(), -2);
    }
}