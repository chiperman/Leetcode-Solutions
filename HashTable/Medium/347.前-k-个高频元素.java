
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */
import java.util.*;

// @lc code=start

// 小根堆+哈希表
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
        // 出现次数按从队头到队尾的顺序是从小到大排，出现次数最多的在队头(相当于小顶堆)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);

        // 小顶堆只需要维持 k 个元素有序
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[] { entry.getKey(), entry.getValue() });
            } else {
                // 当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                if (entry.getValue() > priorityQueue.peek()[1]) {
                    // 弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    priorityQueue.poll();
                    priorityQueue.add(new int[] { entry.getKey(), entry.getValue() });
                }
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            // 依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }
}

// 大根堆+哈希表
class Solution2 {
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
