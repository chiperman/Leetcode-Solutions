/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start

import java.util.*;

class Solution {
    public String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }

        // 定义两个个队列
        Deque<Character> queue1 = new ArrayDeque<>();
        Deque<Character> queue2 = new ArrayDeque<>();

        char[] ch = s.toCharArray();
        // 将字符数组存入队列
        for (char c : ch) {
            queue1.offer(c);
        }

        while (!queue1.isEmpty()) {
            if (queue2.isEmpty()) {
                queue2.offer(queue1.pollFirst());
            } else {
                // 如果 queue2 的队尾元素 等于 queue1 的队头元素。
                // 删除 queue1 队头元素，删除 queue2 队尾元素
                if (queue2.peekLast() == queue1.peek()) {
                    queue2.pollLast();
                    queue1.pollFirst();
                } else {
                    queue2.offer(queue1.pollFirst());
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue2.isEmpty()) {
            sb.append(queue2.pollFirst());
        }

        return new String(sb);
    }
}

class Solution2 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (top >= 0 && sb.charAt(top) == c) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(c);
                top++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end
