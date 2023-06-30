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
 * 
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */

class Solution {
    /**
     * 比较当前节点与下一个节点的值是否相等来判断是否存在重复元素。如果相等，将慢指针的next指向快指针，跳过重复元素；如果不相等，将慢指针向后移动。
     * 1. 首先，检查链表是否为空，如果为空，则直接返回空。
     * 2. 初始化快慢指针，初始时都指向头节点。
     * 3. 使用快指针遍历链表，直到快指针到达链表末尾（即**`fast.next == null`**）。
     * 4. 比较快指针和慢指针所指节点的值是否相等。如果相等，说明存在重复元素，将慢指针的**`next`**指向快指针，
     *    跳过重复元素；如果不相等，将慢指针向后移动，并将慢指针的**`next`**指向快指针。
     * 5. 遍历完成后，断开与后面重复元素的连接，将慢指针的**`next`**设置为**`null`**。
     * 6. 返回头节点。
     */
    public ListNode deleteDuplicates1(ListNode head) {
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

    /**
     * 只需要遍历一次即可，如果 cur.val == cur.next.val（当前节点的值等于当前节点下一个节点的值），就让当前节点指向下下一个节点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}