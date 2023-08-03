/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 假设 s = abc，那么 str = s + s，得到 str = abcabc
        // 然后掐头去尾，newStr = bcab，这个时候如果 newStr 里面包含 s
        // 就说明 s 是 str 的字串
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        // KMP
        if (s.equals("")) {
            return false;
        }

        int len = s.length();
        s = " " + s;
        char[] ch = s.toCharArray();
        int[] next = new int[len + 1];

        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j 回到前一位置 next 数组所对应的值
            while (j > 0 && ch[i] != ch[j + 1]) {
                j = next[j];
            }
            if (ch[i] == ch[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}

// @lc code=end
