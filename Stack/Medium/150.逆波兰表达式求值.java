/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

import java.util.LinkedList;

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = Integer.parseInt(stack.pop());
                int num1= Integer.parseInt(stack.pop());
                int result = 0;
                if (tokens[i].equals("+")) {
                    result = num1 + num2;
                } else if (tokens[i].equals("-")) {
                    result = num1 - num2;
                } else if (tokens[i].equals("*")) {
                    result = num1 * num2;
                } else if (tokens[i].equals("/")) {
                    result = num1 / num2;
                }

                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }
        int answer = Integer.parseInt(stack.pop());
        return answer;
    }
}
// @lc code=end
