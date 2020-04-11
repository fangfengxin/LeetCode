package April.problem_0887_SuperEggDrop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperEggDropTest {
    private SuperEggDrop solution;
    private int K;
    private int N;
    private int expected;

    @Before
    public void setUp() {
        solution = new SuperEggDrop();
        K = 3;
        N = 14;
        expected = 4;
    }

    @Test
    public void testSuperEggDrop() {
        int result = solution.superEggDrop(K, N);
        assertEquals(expected, result);
    }
}