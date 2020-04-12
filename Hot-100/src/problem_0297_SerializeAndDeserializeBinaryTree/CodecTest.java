package problem_0297_SerializeAndDeserializeBinaryTree;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class CodecTest {
    @Test
    public void test() {
        // TreeNode root = TreeNode.of(1, 2);
        TreeNode root = TreeNode.of(1, 2, 3, null, null, 4, 5);
        /*
         *     1
         *    / \
         *   2   3
         *      / \
         *     4   5
         */
        Codec codec = new Codec();
        String serializeStr = codec.serialize(root);
        System.out.println(serializeStr);
        TreeNode deserialize = codec.deserialize(serializeStr);
        assertEquals(root.toString(), deserialize.toString());
    }
}