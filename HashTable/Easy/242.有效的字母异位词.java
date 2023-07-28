/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        // 定义一个数组，存放 a-z 26个字母，统计每个字母在 s 出现的次数
        // s 中出现一次，下标 ++
        // t 中出现一次，下标 --
        int[] record = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            // 假设字符串 s = "anagram"，那么第一个字符 'a' 与 'a' 的 ASCII 的差值等于 0
            // 所以在 record 数组的第 0 个，即record[0]，进行 ++ 操作
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
