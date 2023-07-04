/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    /**
     * 增加一个假的头节点连在 `head` 的头节点前面，最后返回 `newHead.next`
     * 然后用两个指针 cur 和 pre 分别指向前后两个节点，比较 `cur.next.val` 和 `pre.next.val` 的值，然后进行前进
     */
    public ListNode1 deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 增加一个假头节点
        ListNode newHead = new ListNode(1);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (pre.next.val != cur.next.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                while (cur != null && cur.next != null && cur.next.val == pre.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    /**
     * 还是要增加假头节点，和解法一不同点在于
     * 比较的的是：`cur.val` 和 `pre.next.val` 的值
     */
    public ListNode2 deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 增加一个假头节点
        ListNode newHead = new ListNode(1);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head.next;

        while (cur != null) {
            if (pre.next.val != cur.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                while (cur != null && cur.val == pre.next.val) {
                    cur = cur.next;
                }
                pre.next = cur;
                if (cur == null) {
                    cur = null;
                } else {
                    cur = cur.next;
                }
            }
        }
        return newHead.next;
    }
}
// @lc code=end
