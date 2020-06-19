package June.problem_0125_ValidPalindrome;

/*
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */

/**
 * @Author hustffx
 * @Date 2020/6/19 11:50
 */
public class ValidPalindrome {
    /**
     * 方法：筛选 + 翻转字符串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();

        return s1.equals(s2);
    }

    /**
     * 方法2：在原字符串上直接判断
     */
    public boolean isPalindrome2(String s) {
        char[] charArray = s.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(charArray[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(charArray[right])) {
                right--;
            }

            if (left < right) {
                if (Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right])) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
