/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // 让 pre 走到 left 节点的前一个位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 让 rightNode 变成 right 的节点位置
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 让需要反转的区间独立出来
        pre.next = null;
        rightNode.next = null;

        ListNode pre1 = null;
        ListNode cur1 = leftNode;

        // 反转需要反转的区间
        while (cur1 != null) {
            ListNode tmp = cur1.next;
            cur1.next = pre1;
            pre1 = cur1;
            cur1 = tmp;
        }

        // 让反转后的区间重新加入原始链表
        pre.next = rightNode;
        leftNode.next = curr;
        return dummy.next;

    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next = cur.next;

        for (int i = 0; i < right - left; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end
