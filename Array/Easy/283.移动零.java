/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums);
    }
}

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
    }
}
// @lc code=end