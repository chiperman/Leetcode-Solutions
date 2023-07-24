/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 设置 res 用来保存输出结果
        List<List<Integer>> res = new LinkedList<>();

        // 设置一个队列，用来存储二叉树中的元素
        Queue<TreeNode> queue = new ArrayDeque<>();

        // 边界情况处理
        if (root == null) {
            return res;
        }

        // 队列添加二叉树的根节点
        queue.offer(root);

        // 遍历队列，直到队列为空，说明访问了二叉树中所有的节点
        while (!queue.isEmpty()) {
            // 用来记录 queue 的长度，即每层节点的个数
            int size = queue.size();

            // 用来保存每一层节点，保存成功后添加到 res 中
            List<Integer> tempRes = new LinkedList<>();

            // 使用 for 循环，将 queue 中的元素添加的 temp 中
            for (int i = 0; i < size; i++) {
                // 从 queue 中取出一个节点         
                TreeNode node = queue.poll();

                // 把节点存放到 list 中
                tempRes.add(node.val); //将节点值加入list

                // 判断当前节点的左子节点是否有值，如果有，则添加到 queue 中
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // 判断当前节点的右子节点是否有值，如果有，则添加到 queue 中    
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 把存放了每一层元素的数组 temp 添加到 res 中
            res.add(tempRes);
        }
        return res;
    }
}
// @lc code=end
