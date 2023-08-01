/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return 0;
        }

        deque.offer(root);
        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return depth;
    }
}
// @lc code=end
