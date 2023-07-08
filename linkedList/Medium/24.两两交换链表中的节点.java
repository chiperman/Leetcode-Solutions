/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        ListNode temp;
        ListNode temp1;

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next;
            temp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
// @lc code=end
