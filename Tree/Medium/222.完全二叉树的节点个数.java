/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int num = 0;

        if (root == null) {
            return num;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                num++;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return num;
    }
}

class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = countNodes(root.left);
        int rightMax = countNodes(root.right);

        return leftMax + rightMax + 1;
    }
}

class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        int leftDepth = 0;
        int rightDepth = 0;

        while (leftNode != null) {
            leftDepth++;
            leftNode = leftNode.left;
        }

        while (rightNode != null) {
            rightDepth++;
            rightNode = rightNode.right;
        }

        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
// @lc code=end
