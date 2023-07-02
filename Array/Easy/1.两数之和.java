/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 7, 11, 15 };

        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + "" + result[1]);
    }
}

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
// @lc code=end
