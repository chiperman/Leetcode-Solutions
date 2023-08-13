/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start

import algm.TreeNode;

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

    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftBoolean = isValidBST(root.left);
        if (!leftBoolean) {
            return false;
        }

        if (max != null && root.val <= max.val) {
            return false;
        }

        max = root;

        boolean rightBoolean = isValidBST(root.right);

        return rightBoolean;

    }
}
// @lc code=end
