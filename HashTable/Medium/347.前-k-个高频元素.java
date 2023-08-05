
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果为空，添加键值对
            // 如果不为空，值+1并更新 map
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], 1);
            } else {
                int value = hashMap.get(nums[i]) + 1;
                hashMap.put(nums[i], value);
            }
        }

        // 在优先队列中存储二元组(num,count)，count 表示元素值 num 在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从大到小排，出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            priorityQueue.add(new int[] { entry.getKey(), entry.getValue() });
        }

        // 依次从队头弹出 k 个,就是出现频率前 k 高的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }
}
// @lc code=end
