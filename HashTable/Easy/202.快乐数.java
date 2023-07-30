
/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNumber(n);
        }
        return n == 1;
    }

    public int getNumber(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n = n / 10;
        }
        return res;
    }
}
// @lc code=end
