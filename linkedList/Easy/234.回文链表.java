/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        // 定义快慢节点
        ListNode fast = head;
        ListNode slow = head;

        /**
         * 快指针先走，每次走 2 步 ，慢指针每次走 1 步
         * 当快指针走到尾巴或者尾巴前一个位置
         * 慢指针指向：
         *      1. 如果链表长度为奇数：慢指针指向链表中点，下一个节点开始回文
         *      2. 如果链表长度为偶数，慢指针指向正序的最后一位，下一位开始回文
         * 如果fast指针没有指向null，说明链表长度为奇数，slow还要再前进一步
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // 先加入栈然后再前进
            stack.push(slow.val);
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty(); // 栈应该为空才是回文链表
    }

    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        ListNode cur = head;

        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;

    }
}
// @lc code=end
