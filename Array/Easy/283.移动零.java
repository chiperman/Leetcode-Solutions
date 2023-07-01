class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums);
    }

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
