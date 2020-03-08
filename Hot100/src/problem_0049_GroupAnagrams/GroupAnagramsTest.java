package problem_0049_GroupAnagrams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GroupAnagramsTest {
    private GroupAnagrams solution;
    private String[] strs;
    private List<List<String>> expected;

    @Before
    public void init() {
        solution = new GroupAnagrams();
        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        expected = Arrays.asList(
                Arrays.asList("ate", "eat", "tea"),
                Arrays.asList("nat", "tan"),
                Collections.singletonList("bat")
        );
    }

    @Test
    public void testGroupAnagrams1() {
        List<List<String>> result = solution.groupAnagrams1(strs);
        for (List<String> list : result) {
            Collections.sort(list);
        }
        result.sort((o1, o2) -> o2.size() - o1.size());
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagrams2() {
        List<List<String>> result = solution.groupAnagrams2(strs);
        for (List<String> list : result) {
            Collections.sort(list);
        }
        result.sort((o1, o2) -> o2.size() - o1.size());
        Assert.assertEquals(expected, result);
    }
}
