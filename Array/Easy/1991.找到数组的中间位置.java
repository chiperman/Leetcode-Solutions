/*
 * @lc app=leetcode.cn id=1991 lang=java
 *
 * [1991] 找到数组的中间位置
 */

// @lc code=start

class Solution {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int sum = 0;

        // 求和
        for (int i : nums) {
            sum += i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
// @lc code=end