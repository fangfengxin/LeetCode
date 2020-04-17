package problem_0394_DecodeString;

/*
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */

import java.util.LinkedList;

/**
 * @Author hustffx
 * @Date 2020/4/17 14:55
 */
public class DecodeString {
    /**
     * 方法1：辅助栈
     * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
     * 1. 当 c 为数字时，将数字字符转化为数字 count，用于后续倍数计算；
     * 2. 当 c 为字母时，在 sb 尾部添加 c；
     * 3. 当 c 为 [ 时，将当前 count 和 sb 入栈，并分别置空、置 0：
     * 3.1. 记录此 [ 前的临时结果 sb 至栈，用于发现对应 ] 后的拼接操作；
     * 3.2. 记录此 [ 前的倍数 count 至栈，用于发现对应 ] 后，获取 count × [...] 字符串。
     * 3.3. 进入到新 [ 后，count 和 sb 重新记录。
     * 4. 当 c 为 ] 时，countStack 和 strStack 出栈，拼接字符串 sb = last_sb + cur_count * sb，其中:
     * 4.1. last_sb 是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     * 4.2. cur_count 是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
     */
    public String decodeString1(String s) {
        LinkedList<Integer> countStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                strStack.push(sb.toString());
                count = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer curCount = countStack.pop();
                tmp.append(sb.toString().repeat(curCount));
                sb = new StringBuilder(strStack.pop() + tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 方法2：递归
     * 总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
     * 当 s[i] == ']' 时，返回当前括号内记录的 sb 字符串与 ] 的索引 i （更新上层递归指针位置）；
     * 当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 sb + count * tmp 拼接字符串。
     * 遍历完毕后返回 sb。
     */
    public String decodeString2(String s) {
        return decode(s, 0)[0];
    }

    /**
     * 递归解码
     *
     * @param s 需要解码的字符串
     * @param i 找到的 ] 的位置
     * @return
     */
    private String[] decode(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                // 递归获得当前 [ 到与之匹配的 ] 之间的字符串
                String[] decode = decode(s, i + 1);
                // 更新坐标为找到的 ] 的位置
                i = Integer.parseInt(decode[1]);
                // 将递归获得的字符串重复count遍再加入到sb结果中
                sb.append(decode[0].repeat(count));
                count = 0;
            } else if (c == ']') {
                return new String[]{sb.toString(), i + ""};
            } else {
                sb.append(c);
            }
            i++;
        }
        return new String[]{sb.toString()};
    }
}
