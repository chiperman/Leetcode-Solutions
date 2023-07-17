/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
// class Main9 {
//     public static void main(String[] args) {
//         Solution9 solution = new Solution9();
//         int x = 10001;
//         System.out.println(solution.isPalindrome(x));
//     }
// }

// @lc code=start
class Solution {
    // 转化为数组
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int[] arrays = new int[str.length()];

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = str.charAt(i);
        }

        int fast = 0;
        int slow = arrays.length - 1;
        while (fast < slow) {
            if (arrays[fast] != arrays[slow]) {
                return false;
            }
            fast++;
            slow--;
        }

        return true;
    }
}

class Solution2 {
    // 取模运算
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int cur = 0;
        int num = x;

        while (num != 0) {
            cur = num % 10 + cur * 10;
            num /= 10;
        }

        if (cur == x) {
            return true;
        } else {
            return false;
        }
    }
}

class Solution3 {
    // 反转一半数字
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
// @lc code=end
