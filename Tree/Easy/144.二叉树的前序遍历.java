/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);

    }
}

class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;

            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
// @lc code=end
