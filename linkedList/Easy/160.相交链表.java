/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /*
     * 使用栈，可以优化为哈希表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode answer = null;

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode A = stackA.pop();
            ListNode B = stackB.pop();
            if (A == B) {
                answer = A;
            } else {
                return answer;
            }
        }

        return answer;
    }
}

class Solution2 {
    /**
     * 双指针
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;

        while (A != B) {
            if (A == null) {
                A = headB;
            } else {
                A = A.next;
            }

            if (B == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }
}
// @lc code=end
