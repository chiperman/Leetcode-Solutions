/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode breakPoint = null;

        // h        b              f              
        // 5  1  3  6  4  8  9  7  2
        //             s        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                breakPoint = slow;
            }
            slow = slow.next;

        }

        breakPoint.next = null;

        // h        b                         f              
        // 5  1  3  6             4  8  9  7  2
        //                        s        

        ListNode sort1 = sortList(head);
        ListNode sort2 = sortList(slow);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (sort1 != null && sort2 != null) {
            if (sort1.val <= sort2.val) {
                cur.next = sort1;
                sort1 = sort1.next;
            } else {
                cur.next = sort2;
                sort2 = sort2.next;
            }
            cur = cur.next;

        }
        if (sort1 != null) {
            cur.next = sort1;
        } else if (sort2 != null) {
            cur.next = sort2;
        }
        return dummy.next;
    }
}
// @lc code=end
