/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

class Main {
    public static void main(String[] args) {
        int[] nums = { 1 };
        Solution solution = new Solution();
        solution.removeDuplicates(nums);
    }
}

// @lc code=start
class Solution {

    public int removeDuplicates(int[] nums) {
        int lPoint = 0;
        int rPoint = 1;
        for (rPoint = 1; rPoint < nums.length; rPoint++) {
            if (nums[lPoint] != nums[rPoint]) {
                nums[lPoint + 1] = nums[rPoint];
                lPoint++;
            }
        }
        return lPoint + 1;
    }
}
// @lc code=end
