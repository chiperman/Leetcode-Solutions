/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    // 迭代
    public ListNode1 reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode curr = head;

        // 循环遍历然后交换顺序
        while (curr != null) {
            ListNode next = curr.next; // 后一个节点
            curr.next = newHead; // 把当前节点指向新的链表
            newHead = curr; // 更新新的链表的头节点
            curr = next; // 更新当前节点
        }

        head = newHead; // 把原来的链表的头节点改成新的链表的头节点
        return head; // 返回反转后的头节点
    }

    // 递归*
    public ListNode2 reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
// @lc code=end
