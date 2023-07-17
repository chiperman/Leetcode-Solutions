/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List list) {
        if (root == null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}

class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 如果当前节点有左子树，继续向左子树找
                if (root.left != null) {
                    root = root.left;
                } else {
                    // 如果当前节点无左子树，在右子树继续找
                    root = root.right;
                }
            }
            // 跳出循环的条件是 root 为空，那当前栈顶元素为叶子节点。
            // 弹出栈顶元素，并加入结果数组
            root = stack.pop();
            res.add(root.val);
            // 如果栈不为空，且当前栈顶元素的左节点是刚刚跳出的栈顶元素 cur
            // 则转向遍历右子树当前栈顶元素的右子树
            if (!stack.isEmpty() && stack.peek().left == root) {
                root = stack.peek().right;
            } else {
                // 否则证明当前栈顶元素无左右子树，那当前的栈顶元素弹出。
                root = null;
            }
        }
        return res;
    }
}
// @lc code=end
