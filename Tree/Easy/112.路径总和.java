/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();

        // 为空就返回 false
        if (root == null) {
            return false;
        }

        queue.offer(root);
        queueVal.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                Integer preVal = queueVal.poll();

                // 如果不大于，则先 queue 添加左右子节点
                // queueVal 添加总和
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    queueVal.offer(curNode.left.val + preVal);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    queueVal.offer(curNode.right.val + preVal);
                }

                if (curNode.right == null && curNode.left == null && preVal == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
