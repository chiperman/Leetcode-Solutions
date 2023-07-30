/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
        if (root == null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 将传入的两个节点穿起来
        node1.next = node2;
        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
        traverse(node2.left, node2.right);
    }
}

class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node cur = queue.remove();

                // 连接
                if (i < size - 1) {
                    cur.next = queue.peek();
                }

                // 拓展下一层节点
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

class Solution3 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点
        //或所有叶子节点都出串联完后循环就退出了
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                //将tmp的左右节点都串联起来
                //注:外层循环已经判断了当前节点的left不为空
                tmp.left.next = tmp.right;
                //下一个不为空说明上一层已经帮我们完成串联了
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                //继续右边遍历
                tmp = tmp.next;
            }
            //从下一层的最左边开始遍历
            pre = pre.left;
        }
        return root;
    }
}
// @lc code=end
