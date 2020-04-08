package problem_0234_PalindromeLinkedList;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

public class PalindromeLinkedListTest {
    PalindromeLinkedList solution;
    ListNode head;
    boolean expected;

    @Before
    public void setUp() {
        solution = new PalindromeLinkedList();
        head = ListNode.of(1, 2);
        expected = false;
    }

    @Test
    public void testIsPalindrome1() {
        boolean result = solution.isPalindrome1(head);
        assertEquals(expected, result);
    }

    @Test
    public void testIsPalindrome2() {
        boolean result = solution.isPalindrome2(head);
        assertEquals(expected, result);
    }
}