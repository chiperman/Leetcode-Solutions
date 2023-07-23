/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return result;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                // 判断当前节点的左子节点是否有值，如果有，则添加到 queue 中
                if (node.left != null) {
                    queue.add(node.left);
                }

                // 判断当前节点的右子节点是否有值，如果有，则添加到 queue 中    
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
// @lc code=end
