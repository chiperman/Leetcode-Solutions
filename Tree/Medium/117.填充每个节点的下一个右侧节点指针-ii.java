/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return root;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int siez = queue.size();

            for (int i = 0; i < siez; i++) {
                Node cur = queue.poll();

                if (i < siez - 1) {
                    cur.next = queue.peek();
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }
}
// @lc code=end
