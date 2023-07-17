/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    // 解法一：暴力解法
    public int searchInsert1(int[] nums, int target) {
        // 目标值在数组所有元素之前
        if (target <= nums[0]) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // 目标值等于数组中某一个元素  
            if (target == nums[i]) {
                return i;
            }
            // 目标值插入数组中的位置 
            if (nums[i] <= target && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        // 目标值在数组所有元素之后的情况 
        return nums.length;
    }
}

class Solution2 {
    // 解法二：二分法
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出 等同于(left + right)/2
            int middle = left + ((right - left) / 2);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] >= target) {
                right = middle - 1;
            }
        }
        return left;
    }
}
// @lc code=end
