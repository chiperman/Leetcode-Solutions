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

/**
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        // 如果快指针不等于慢指针，就让慢指针的 next->fast 指向快指针
        while (fast.next != null) {
            fast = fast.next;
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}