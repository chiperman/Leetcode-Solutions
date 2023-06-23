class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3 };
        Solution solution = new Solution();
        solution.removeDuplicates(nums);
    }

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