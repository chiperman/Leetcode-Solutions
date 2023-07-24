/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double avgNum = 0.0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                avgNum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(avgNum / levelSize);
        }
        return res;
    }
}
// @lc code=end
