package June.problem_lcof_09_ImplementQueueByStack;

import org.junit.jupiter.api.Test;

/**
 * @Author hustffx
 * @Date 2020/6/30 12:08
 */
class CQueueTest {
    @Test
    public void test() {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        int i = cQueue.deleteHead();
        System.out.println(i);
    }
}