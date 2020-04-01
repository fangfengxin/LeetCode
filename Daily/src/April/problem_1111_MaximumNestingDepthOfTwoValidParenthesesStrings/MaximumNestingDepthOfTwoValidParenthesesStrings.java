package April.problem_1111_MaximumNestingDepthOfTwoValidParenthesesStrings;

/*
 * 1111. 有效括号的嵌套深度
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *  - 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 *  - A 或 B 中的元素在原字符串中可以不连续。
 *  - A.length + B.length = seq.length
 *  - max(depth(A), depth(B)) 的可能取值最小。
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *  - answer[i] = 0，seq[i] 分给 A 。
 *  - answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 * 示例 1：
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 *
 * 示例 2：
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *
 * 提示：
 * 1 <= text.size <= 10000
 *
 * 有效括号字符串：
 * 仅由 "(" 和 ")" 构成的字符串，对于每个左括号，都能找到与之对应的右括号，反之亦然。
 * 下述几种情况同样属于有效括号字符串：
 *   1. 空字符串
 *   2. 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 *   3. 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 嵌套深度：
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *   1. s 为空时，depth("") = 0
 *   2. s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 *   3. s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 */
public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    /**
     * 方法1：使用栈进行括号匹配
     * 栈中只会存放 (，因此我们不需要维护一个真正的栈，只需要用一个变量模拟记录栈的大小。
     * depth 其实就是栈的最大深度，本题要让 A 字符串和 B 字符串的 depth 尽可能的接近。
     * 因为 seq 对应的栈上，每个左括号都对应一个深度，而这个左括号，要么是 A 的，要么是 B 的。
     * 所以，栈上的左括号只要按奇偶分配给 A 和 B 就可以。
     */
    public int[] maxDepthAfterSplit1(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                res[i] = depth % 2;
            } else {
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }

    /**
     * 方法2：找规律
     * 括号序列   ( ( ) ( ( ) ) ( ) )
     * 下标编号   0 1 2 3 4 5 6 7 8 9
     * 嵌套深度   1 2 - 2 3 - - 2 - -
     * 嵌套深度   - - 2 - - 3 2 - 2 1
     * 对于字符串中的任意一个左括号 (，它的下标编号为 x，嵌套深度为 y。
     * 如果它之有 l 个左括号和 r 个右括号，那么根据嵌套深度的定义，有： y = l - r + 1
     * 下标编号与 l 和 r 的关系也可以直接得到，注意下标编号从 0 开始： x = l + r
     * 由于 l - r 和 l + r 同奇偶，因此 l - r + 1（即 y）和 l + r（即 x）的奇偶性相反。
     * 对于字符串中的任意一个右括号 )，它的下标编号为 x，嵌套深度为 y。
     * 如果它之有 l 个左括号和 r 个右括号，那么根据嵌套深度的定义，有： y = l - r
     * 下标编号与 l 和 r 的关系也可以直接得到，注意下标编号从 0 开始： x = l + r
     * 因此 y 和 x 的奇偶性相同。
     * 这样以来，我们只需要根据每个位置是哪一种括号以及该位置的下标编号，就能确定将对应的对应的括号分到哪个组了。
     */
    public int[] maxDepthAfterSplit2(String seq) {
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                res[i] = 1 - i % 2;
            } else {
                res[i] = i % 2;
            }
        }
        return res;
    }
}
