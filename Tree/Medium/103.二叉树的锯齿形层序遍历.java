/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        // flags = true，表明奇数行，从左向右遍历
        // flags = false，表面偶数行，从右向左遍历
        Boolean flags = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            Deque<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (flags == true) {
                    temp.offerLast(node.val);
                } else {
                    temp.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flags = !flags;
            result.add(new LinkedList<Integer>(temp));
        }
        return result;
    }
}
// @lc code=end
