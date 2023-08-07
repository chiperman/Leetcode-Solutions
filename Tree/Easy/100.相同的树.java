/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(p);
        deque.offerLast(q);
        while (!deque.isEmpty()) {
            p = deque.pollFirst();
            q = deque.pollLast();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            deque.offerFirst(p.left);
            deque.offerFirst(p.right);
            deque.offerLast(q.left);
            deque.offerLast(q.right);
        }
        return true;
    }
}

class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return compare(p, q);
    }

    boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else if (p.val != q.val) {
            return false;
        }
        boolean outside = compare(p.left, q.left); // 左子树：左、 右子树：左 （相对于求对称二叉树，只需改一下这里的顺序）
        boolean inside = compare(p.right, q.right);// 左子树：左、 右子树：左 （相对于求对称二叉树，只需改一下这里的顺序）
        return outside && inside;
    }
}
// @lc code=end
