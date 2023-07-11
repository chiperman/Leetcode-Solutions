/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;

            } else {
                count = Math.max(count, tempCount);
                tempCount = 0;
            }
        }
        // 确保最后数组结束后更新 count 的值
        count = Math.max(count, tempCount);
        return count;
    }
}
// @lc code=end
