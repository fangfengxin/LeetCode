package problem_0297_SerializeAndDeserializeBinaryTree;

/*
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.substring(1, data.length() - 1).split(", ");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(0);
        stack.push(root);
        TreeNode node;
        TreeNode parent;
        int index = 0;
        while (index < strs.length) {
            while (!"null".equals(strs[index])) {
                node = new TreeNode(Integer.parseInt(strs[index]));
                stack.peek().left = node;
                stack.push(node);
                index++;
            }
            index++;
            if (index >= strs.length) {
                break;
            }
            while (index < strs.length && "null".equals(strs[index])) {
                stack.pop();
                index++;
            }
            if (index >= strs.length) {
                break;
            }
            parent = stack.pop();
            node = new TreeNode(Integer.parseInt(strs[index]));
            parent.right = node;
            stack.push(node);
            index++;
        }
        return root.left;
    }
}
