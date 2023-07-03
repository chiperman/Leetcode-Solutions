
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = { 2, 7, 11, 15 };

        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + "" + result[1]);
    }
}

// @lc code=start
class Solution1 {
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

class Solution2 {
    /**
     * ❌❌❌
     * 这个答案的问题在于，如果给定的 nums[] = [3,3]，这种已经重复的数字
     * 再添加到 HashMap 中会导致重复而不添加，最后答案出错
     * 所以左右双指针只适用于两种情况：
     *     1. 返回的答案是元素内容，而不是索引
     *     2. 给定的 nums[] 数组不存在重复的元素且答案不能是这两个重复的元素
     */
    public int[] twoSum(int[] nums, int target) {
        // 用一个数组存排序后的 nums
        int[] sortedNums = Arrays.copyOf(nums, nums.length);

        // 排序
        Arrays.sort(sortedNums);

        // 构建索引
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];

        while (left < right) {
            if (target - sortedNums[left] < sortedNums[right]) {
                right--;
            } else if (target - sortedNums[left] > sortedNums[right]) {
                left++;
            } else {
                result[0] = indexMap.get(sortedNums[left]);
                result[1] = indexMap.get(sortedNums[right]);
                return result;
            }
        }
        return result;
    }
}

class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 使用哈希表来计算答案
         */
        int[] result = new int[2];

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            // 如果 hashMap 中存在 target - nums[i] 的值
            // 说明这两个值分别是答案的第一个位置和第二个位置
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
                // return result;

            }
            // 如果不存在，则把这个数字添加到 hashMap 中，键是这个数字，值是这个值在原数组的下标
            hashMap.put(nums[i], i);
        }
        return result;
    }
}
// @lc code=end
