/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return cur;
            } else {
                hashSet.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}

class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;

                }
                return fast;
            }

        }
        return null;
    }
}
// @lc code=end
