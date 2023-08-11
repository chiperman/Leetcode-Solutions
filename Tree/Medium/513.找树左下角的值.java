/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

// @lc code=start

import java.util.*;

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

/**
* 层序遍历
*/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int val = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (i == 0) {
                    val = cur.val;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }

        return val;
    }
}

/**
 * 递归法
 */
class Solution2 {
    int val = 0;
    int Deep = -1;

    public int findBottomLeftValue(TreeNode root) {
        val = root.val;
        findLeftVal(root, 0);
        return val;
    }

    public void findLeftVal(TreeNode root, int deep) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                val = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            findLeftVal(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftVal(root.right, deep + 1);
        }
    }
}
// @lc code=end
