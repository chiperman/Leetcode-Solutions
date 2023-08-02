/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 1.去除首尾以及多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转每个单词
        reverseWord(sb);

        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            // 如果得到的不是空格，或者新的字符串也不是空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char tmp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    public void reverseWord(StringBuilder s) {
        // "a good example" → "elpmaxe doog a"
        int start = 0;
        int end = 1;
        int n = s.length();
        while (start < n) {
            while (end < n && s.charAt(end) != ' ') {
                end++;
            }
            reverseString(s, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
// @lc code=end
