import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        solution.merge(intervals);
    }
}

/**
 * 解题思路如下：
 * 1.先对输入数组按照区间左边的值进行升序排列
 * 2.初始化一个变量 result，用于存储合并直接的区间结果
 * 3.遍历排序后的所有区间，针对每个区间做如下的处理：
 *   1.如果当前处理的区间是第一个区间的话，那么直接将区间加入到 result
 *   2.比较当前处理区间左边的值 (currLeft) 和 result 中最后一个区间右边的值 (resultLastRight) ：
 *      1.如果 resultLastRight < currLeft，说明没有重叠，那么直接将当前处理的区间加入到 result
 *      2.否则，说明有重叠，那么将 result 中最后一个区间的右边的值更新为：当前处理区间右边值和 resultLastRight 的最大值
 * 4.将 result 转成数组，并返回
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();

        // 对整个二维数组进行排序，二维数组的第一个位置都是按序排列
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        // 循环 interval
        for (int i = 0; i < intervals.length; i++) {
            // 如果当前区间是第一个区间 || 如果 result 结果里面的最后一个元素的第二位小于当前循环到的元素的第一位
            // 不重叠，直接添加到 result
            if (result.isEmpty() || result.get(result.size() - 1)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                // 如果有重叠，那么把 result 里面最后一个元素 resultRight 的第二个元素设置为处理区间右边值和 resultRight 的最大值
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end
