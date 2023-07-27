/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int loop = 0; // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0; // 每次循环的开始点(start, start)
        int count = 1; // 定义填充数字
        int i, j;

        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = count;
                count++;
            }

            for (i = start; i < n - loop; i++) {
                res[i][j] = count;
                count++;
            }

            for (; j >= loop; j--) {
                res[i][j] = count;
                count++;
            }

            for (; i >= loop; i--) {
                res[i][j] = count++;
            }

            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
}

class Solution2 {
    public int[][] generateMatrix(int n) {
        // 定义四条边
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int[][] res = new int[n][n];

        int num = 1;
        int target = n * n;

        while (num <= target) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
// @lc code=end
