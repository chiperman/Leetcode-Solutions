/*
 * @lc app=leetcode.cn id=724 lang=java
 * @lcpr version=21909
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    /**
     * 解法一：
     * 循环遍历数组，分别计算中心下标的左侧总和 `leftSum` 和右侧总和 `rightSum` ，
     * 如果左右侧相等则返回当前的中心下标 `middle`，
     * 如果不等则再次循环，并且重置右侧总和 `rightSum = 0`
     * 
     * 缺点：实际复杂度高，两次循环遍历
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int middle = 0;

        for (int i = 0; i < nums.length; i++) {
            middle = i;
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum += nums[i - 1];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {
                return middle;
            }
            rightSum = 0;
        }

        return -1;
    }
}

class Solution2 {
    /**
     * 解法二
     * 左侧总和 * 2 + 中心下表数据 = 总和
     */
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftSum = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == total) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

class Solution3 {
    /*
     * 解法三
     */
    public int pivotIndex(int[] nums) {
        // 左侧总和 * 2 + 中心下表数据 = 总和
        int total = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum += nums[i - 1];
            }
            if (leftSum * 2 + nums[i] == total) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1, 7, 3, 6, 5, 6]\n
// @lcpr case=end

// @lcpr case=start
// [1, 2, 3]\n
// @lcpr case=end

// @lcpr case=start
// [2, 1, -1]\n
// @lcpr case=end

 */
