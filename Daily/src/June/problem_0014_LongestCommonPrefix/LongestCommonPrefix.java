package June.problem_0014_LongestCommonPrefix;

/**
 * @Author hustffx
 * @Date 2020/6/15 0:02
 */
public class LongestCommonPrefix {
    /**
     * 方法1：纵向扫描
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    /**
     * 方法2：分治法
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }

        int mid = start + (end - start) / 2;

        String lcpLeft = longestCommonPrefix(strs, start, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, end);

        return longestCommonPrefix(lcpLeft, lcpRight);
    }

    private String longestCommonPrefix(String lcpLeft, String lcpRight) {
        int minLen = Math.min(lcpLeft.length(), lcpRight.length());

        for (int i = 0; i < minLen; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }

        return lcpLeft.substring(0, minLen);
    }

    /**
     * 方法3：二分查找
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 0;
        int high = minLen;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, high);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                if (strs[i].charAt(j) != str0.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
