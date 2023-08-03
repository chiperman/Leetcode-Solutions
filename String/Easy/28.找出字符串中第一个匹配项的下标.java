/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    public void getNext(int[] next, String s) {
        // next 数组下标 -1 开头，然后所有的后移一位
        int j = -1;
        next[0] = j;

        for (int i = 1; i < s.length(); i++) {
            // 因为是看 j 的位置，所以可能 j 是数组下标为 0 的位置，所以 j>=0
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }

            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
// @lc code=end
