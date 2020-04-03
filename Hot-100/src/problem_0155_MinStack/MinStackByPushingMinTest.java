package problem_0155_MinStack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackByPushingMinTest {
    @Test
    public void test() {
        MinStackByPushingMin minStack = new MinStackByPushingMin();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(minStack.getMin(),-3);
        minStack.pop();
        assertEquals(minStack.top(),0);
        assertEquals(minStack.getMin(),-2);
    }
}