/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 对较小长度的哈希表进行映射，减少内存使用
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int num = map.getOrDefault(i, 0) + 1;
            map.put(i, num);
        }
        int[] res = new int[nums1.length];

        int index = 0;
        for (int i : nums2) {
            int num = map.getOrDefault(i, 0);
            if (num > 0) {
                res[index++] = i;
                num--;
                if (num > 0) {
                    map.put(i, num);
                } else {
                    map.remove(i);
                }
            }
        }

        int[] result = Arrays.copyOf(res, index);
        return result;
    }
}
// @lc code=end
