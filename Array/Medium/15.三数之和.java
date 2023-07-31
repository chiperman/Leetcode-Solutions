/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先对数组 nums 进行排序
        // [-1,0,1,2,-1,-4] → [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重 right，要在收获一个结果集之后再进行这个操作
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 去重 left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
