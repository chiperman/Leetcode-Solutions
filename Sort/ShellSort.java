import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90, 54, 72, 65 };
        ShellSort sS = new ShellSort();
        sS.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void shellSort(int[] nums) {
        int len = nums.length;

        // 每次步长缩减一半
        for (int step = len / 2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                int tmp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = tmp;
            }
        }

    }
}
