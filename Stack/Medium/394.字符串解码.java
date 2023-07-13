/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

import java.util.LinkedList;
import java.util.Stack;

// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int multi = 0;

        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_character = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_num.push(multi);
                stack_character.push(result.toString());
                multi = 0;
                result = new StringBuilder();
            } else if (c == ']') {
                int multi_num = stack_num.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < multi_num; i++) {
                    tmp.append(result);
                }
                result = new StringBuilder(stack_character.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 为什么要乘10？因为是从左往右扫描的，如果k不是个位数而是n位整数的话就要通过不停的乘10来更新值
                // c + "" 是因为 Integer.parseInt() 里面的参数需要是字符串，而 c 本身是 Character
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
// @lc code=end
