class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        Solution solution = new Solution();
        solution.pivotIndex1(nums);
        solution.pivotIndex2(nums);
    }

    /**
     * 解法一
     * 左侧总和 * 2 + 中心下表数据 = 总和
     */
    public int pivotIndex1(int[] nums) {
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

    // 解法二
    public int pivotIndex2(int[] nums) {
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
