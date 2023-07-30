/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> res = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                res.add(j);
            }
        }

        int[] arrRes = new int[res.size()];
        int j = 0;
        for (int i : res) {
            arrRes[j++] = i;
        }

        return arrRes;
    }
}
// @lc code=end
