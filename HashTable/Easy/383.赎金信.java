/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
        }

        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            int num = map.getOrDefault(c, 0);
            if (num > 0) {
                num--;
                if (num > 0) {
                    map.put(c, num);
                } else {
                    map.remove(c);
                }
            }
        }

        if (map.isEmpty()) {
            return true;
        }
        return false;
    }
}
// @lc code=end
