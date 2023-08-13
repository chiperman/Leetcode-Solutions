/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
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
    public TreeNode searchBST(TreeNode root, int val) {
        // 因为二叉搜索树，可以根据左小右大的规则先找到节点
        while (root.left != null || root.right != null) {
            if (root.val > val && root.left != null) {
                root = root.left;
            } else if (root.val < val && root.right != null) {
                root = root.right;
            } else {
                break;
            }
        }

        // 如果最后找到的节点!=val，直接返回 null
        if (root.val != val) {
            return null;
        }

        return root;
    }
}
// @lc code=end
