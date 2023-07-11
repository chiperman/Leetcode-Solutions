/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddL = head;
        ListNode oddIndex = head;

        ListNode evenL = head.next;
        ListNode evenIndex = head.next;

        while (evenIndex != null && evenIndex.next != null) {
            oddIndex.next = evenIndex.next;
            oddIndex = oddIndex.next;
            evenIndex.next = oddIndex.next;
            evenIndex = evenIndex.next;
        }
        oddIndex.next = evenL;

        return oddL;
    }
}
// @lc code=end
