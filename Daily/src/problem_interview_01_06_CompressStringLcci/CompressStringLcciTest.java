package problem_interview_01_06_CompressStringLcci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompressStringLcciTest {
    CompressStringLcci solution;
    String S;
    String expected;

    @Before
    public void setUp() {
        solution = new CompressStringLcci();
        S = "aabcccccaaa";
        expected = "a2b1c5a3";
    }

    @Test
    public void testCompressString() {
        String result = solution.compressString(S);
        assertEquals(expected, result);
    }
}