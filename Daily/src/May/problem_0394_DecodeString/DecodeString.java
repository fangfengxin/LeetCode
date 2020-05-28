package May.problem_0394_DecodeString;

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

import java.util.ArrayDeque;

/**
 * @Author hustffx
 * @Date 2020/5/28 22:37
 */
public class DecodeString {
    /**
     * 方法1：递归
     */
    public String decodeString1(String s) {
        return decode(s.toCharArray(), 0)[0];
    }

    /**
     * 递归解码
     *
     * @param s 需要解码的字符串
     * @param i 找到的 ] 的位置
     * @return
     */
    private String[] decode(char[] s, int i) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (i < s.length) {
            char c = s[i];

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

    /**
     * 方法2：栈
     */
    public String decodeString2(String s) {
        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        ArrayDeque<String> strStack = new ArrayDeque<>();
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
                tmp.append(sb.toString().repeat(countStack.pop()));
                sb = new StringBuilder(strStack.pop()).append(tmp);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
