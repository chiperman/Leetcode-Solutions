/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int res_len = 0;
        int res_start = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            // 先判断下标，再判断字符
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (res_len < r - l + 1) {
                    res_start = l;
                    res_len = r - l + 1;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (res_len < r - l + 1) {
                    res_start = l;
                    res_len = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(res_start, res_start + res_len);
    }
}
// @lc code=end
