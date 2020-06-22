package June.problem_lcci_16_18_PatternMatching;

/*
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 *
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * 提示：
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */

/**
 * @Author hustffx
 * @Date 2020/6/22 11:18
 */
public class PatternMatching {
    public boolean patternMatching(String pattern, String value) {
        if ("a".equals(pattern) || "b".equals(pattern)) {
            return true;
        }

        int lenP = pattern.length();
        int lenV = value.length();

        if (lenP == 0) {
            return lenV == 0;
        }

        char[] pChars = pattern.toCharArray();
        char[] vChars = value.toCharArray();

        // value为空时，判断pattern是否只有a或只有b
        if (lenV == 0) {
            boolean aExist = false;
            boolean bExist = false;

            for (char c : pChars) {
                if (c == 'a') {
                    aExist = true;
                } else {
                    bExist = true;
                }

                if (aExist && bExist) {
                    return false;
                }
            }
            return true;
        }

        // 计算pattern里a和b的个数
        int countA = 0;
        int countB = 0;

        for (char c : pChars) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        // a或b的数量为0，判断value能否被等分
        if (countA * countB == 0) {
            if (lenV % lenP != 0) {
                return false;
            } else {
                int len = lenV / lenP;

                for (int i = len; i < lenV; i += len) {
                    if (!stringEquals(vChars, 0, i, len)) {
                        return false;
                    }
                }

                return true;
            }
        }

        // i表示字符串a的长度
        for (int i = 0; i <= lenV / countA; i++) {
            int lenB = (lenV - countA * i) / countB;

            // lenB满足条件才进行判断是否匹配
            if (countA * i + countB * lenB == lenV) {
                int index = 0;

                // 存储a和b的初始索引
                int indexA = -1;
                int indexB = -1;

                boolean notMatch = false;

                for (char c : pChars) {
                    if (c == 'a') {
                        if (indexA == -1) {
                            indexA = index;
                        } else {
                            if (!stringEquals(vChars, indexA, index, i)) {
                                notMatch = true;
                                break;
                            }
                        }
                        index += i;
                    } else {
                        if (indexB == -1) {
                            indexB = index;
                        } else {
                            if (!stringEquals(vChars, indexB, index, lenB)) {
                                notMatch = true;
                                break;
                            }
                        }
                        index += lenB;
                    }

                    // 判断a和b是否相同
                    if (i == lenB && indexA != -1 && indexB != -1 && stringEquals(vChars, indexA, indexB, i)) {
                        notMatch = true;
                        break;
                    }
                }

                if (!notMatch) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断字符串是否相等
     *
     * @param chars
     * @param i
     * @param j
     * @param len
     * @return
     */
    private boolean stringEquals(char[] chars, int i, int j, int len) {
        for (int k = 0; k < len; k++) {
            if (chars[i + k] != chars[j + k]) {
                return false;
            }
        }
        return true;
    }
}
