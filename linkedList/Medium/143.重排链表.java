/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int first = 0;
        int tail = list.size() - 1;

        while (first < tail) {
            list.get(first).next = list.get(tail);
            first++;
            if (first == tail) {
                break;
            }
            list.get(tail).next = list.get(first);
            tail--;
        }
        list.get(first).next = null;
    }
}
// @lc code=end
