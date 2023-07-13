/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

import java.util.Stack;

// @lc code=start

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            char leftSymbol;

            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (symbol == ')') {
                    leftSymbol = stack.pop();
                    if (leftSymbol != '(') {
                        return false;
                    }
                } else if (symbol == ']') {
                    leftSymbol = stack.pop();
                    if (leftSymbol != '[') {
                        return false;
                    }
                } else if (symbol == '}') {
                    leftSymbol = stack.pop();
                    if (leftSymbol != '{') {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }
}
// @lc code=end
