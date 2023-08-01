/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        // 因为每次处理都是 2k 个字符，所以移动也移动 2k 个字符
        for (int i = 0; i < charArray.length; i += 2 * k) {
            // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= charArray.length) {
                reverse(charArray, i, i + k - 1);
                continue;
            }
            // 如果剩余字符小于 k 个，则将剩余字符全部反转
            reverse(charArray, i, charArray.length - 1);
        }

        return new String(charArray);
    }

    public void reverse(char[] charArray, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
        }
    }
}
// @lc code=end
