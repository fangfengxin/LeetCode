package problem_0002_AddTwoNumbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

public class AddTwoNumbersTest {
    private long startTime;
    private AddTwoNumbers solution;
    private ListNode l1;
    private ListNode l2;
    private String expected;

    @Before
    public void init() {
        startTime = System.currentTimeMillis();
        solution = new AddTwoNumbers();
        l1 = ListNode.addAll(1, 4, 5);
        l2 = ListNode.addAll(0, 7);
        expected = ListNode.addAll(1, 1, 6).toString();
    }

    @Test
    public void testAddTwoNumbers() {
        String result = solution.addTwoNumbers1(l1, l2).toString();
        Assert.assertEquals(expected, result);
        System.out.println("执行用时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);
    }
}
