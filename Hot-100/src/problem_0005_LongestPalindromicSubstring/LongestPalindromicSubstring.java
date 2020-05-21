package problem_0005_LongestPalindromicSubstring;

/*
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */

/**
 * @author Administrator
 */
public class LongestPalindromicSubstring {
    /**
     * 方法1：暴力破解
     * 将字符串所有子串都拿来判断是否是回文。
     * 效率过于低下，LeetCode提交超时。
     */
    public String longestPalindrome1(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        String result = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (maxLen < substr.length() && isPalindrome(substr)) {
                    result = substr;
                    maxLen = substr.length();
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2：最长公共子串，使用二维数组
     * 将字符串翻转，找到匹配的最长公共子串。
     * 注意：需要检测公共子串翻转前的索引是否与字符串的索引相同
     */
    public String longestPalindrome2(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        String res = "";
        // 翻转字符串
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        // 数组arr保存公共子串的长度
        int[][] arr = new int[length][length];
        // 保存找到的最长回文字符串的长度
        int maxLen = 0;
        // 保存找到的最长回文字符串的尾部索引
        int maxEnd;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 如果字符相同,当前索引处的值为：前一个索引处存储的最长回文长度+1
                // 边界条件：索引值有一个是指向字符串首位时，数组对应位置设为1
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                // 更新最长回文子串信息
                // 当公共子串的尾部索引变换到原来字符串索引后，加上当前公共子串长度等于当前索引时，可以确定是回文子串
                if ((length - 1 - j) + (arr[i][j] - 1) == i && arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i;
                    res = s.substring(maxEnd - maxLen + 1, maxEnd + 1);
                }
            }
        }
        return res;
    }

    /**
     * 方法3：优化最长公共子串，使用一维数组
     * 而二位数组中每次只需要使用相邻两列的数据，所以使用一维数组优化空间消耗
     */
    public String longestPalindrome3(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        String res = "";
        // 翻转字符串
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        // 数组arr保存公共子串的长度
        int[] arr = new int[length];
        // 保存找到的最长回文字符串的长度
        int maxLen = 0;
        // 保存找到的最长回文字符串的尾部索引
        int maxEnd;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                // 如果字符相同,当前索引处的值为：前一个索引处存储的最长回文长度+1
                // 边界条件：索引值是指向字符串首位时，数组对应位置设为1
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    // 使用二维数组的时候使用的是不同列，所以不用置零
                    arr[j] = 0;
                }
                // 更新最长回文子串信息
                // 当公共子串的尾部索引变换到原来字符串索引后，加上当前公共子串长度等于当前索引时，可以确定是回文子串
                if (arr[j] > maxLen && (length - 1 - j) + (arr[j] - 1) == i) {
                    maxLen = arr[j];
                    maxEnd = i;
                    res = s.substring(maxEnd - maxLen + 1, maxEnd + 1);
                }
            }
        }
        return res;
    }

    /**
     * 方法4：优化暴力破解。动态规划使用二维数组
     * 去掉暴力破解中的重复调用函数判断
     * 如果p(i,j)是回文，则只需要判断i-1和j+1位置的字符是否相同。
     */
    public String longestPalindrome4(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        int maxLen = 0;
        String res = "";
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                p[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1]);
                if (p[i][j] && (j - i + 1) >= maxLen) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 方法5：优化动态规划使用一维数组
     */
    public String longestPalindrome5(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        int length = s.length();
        boolean[] p = new boolean[length];
        int maxLen = 0;
        String res = "";
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j >= i; j--) {
                p[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || p[j - 1]);
                if (p[j] && (j - i + 1) >= maxLen) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 方法6：中心扩展
     * 回文子串有一个对称中心，要么是某个字符，要么是某两个相邻字符的中间位置
     */
    public String longestPalindrome6(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        String res = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                res = s.substring(start, end + 1);
            }
        }
        return res;
    }

    public int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 减1是因为扩展结束比回文字符串实际长度多了2
        return right - left - 1;
    }
}