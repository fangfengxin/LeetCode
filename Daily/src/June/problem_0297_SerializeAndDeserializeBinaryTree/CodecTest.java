package June.problem_0297_SerializeAndDeserializeBinaryTree;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/16 13:33
 */
public class CodecTest {
    @Test
    public void test() {
        TreeNode root = TreeNode.of(1, 2, 3, null, null, 4, 5);
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        assertEquals(root.toString(), deserialize.toString());
    }
}