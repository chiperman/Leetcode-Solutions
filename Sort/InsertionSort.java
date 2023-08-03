import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        InsertionSort iS = new InsertionSort();
        iS.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertionSort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            // 找到待排序元素的前面一个开始比较
            int j = i - 1;

            while (j >= 0 && nums[j] > tmp) {
                // 插入当前元素到正确的位置
                nums[j + 1] = nums[j];
                j--;
            }

            // 插入当前元素到正确的位置
            nums[j + 1] = tmp;
        }
    }
}
