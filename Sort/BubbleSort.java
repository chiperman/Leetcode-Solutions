import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BubbleSort bS = new BubbleSort();
        bS.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            // 定义一个 flag 来判断数组是否已经有序
            boolean flag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
