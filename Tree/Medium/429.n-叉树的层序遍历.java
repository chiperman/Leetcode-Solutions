/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                tmpList.add(cur.val);

                List<Node> children = cur.children;

                if (children == null || children.size() == 0) {
                    continue;
                }

                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            res.add(tmpList);
        }
        return res;
    }
}
// @lc code=end
