/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; // i 起始位置
        int num = 0;
        int result = Integer.MAX_VALUE;
        // j 终止位置
        for (int j = 0; j < nums.length; j++) {
            num += nums[j];
            while (num >= target) {
                result = Math.min(result, j - i + 1);
                num -= nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end
