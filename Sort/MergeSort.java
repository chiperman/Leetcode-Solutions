import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        // int[] nums = { 3, 4, 1, 5, 2, 1 };
        MergeSort mS = new MergeSort();
        mS.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) {
            return;
        }

        // 递归执行里面的左右子数组，当子数组长度为 1 时，开始合并
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        // 合并子数组
        // 暂存需合并区间元素
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间元素
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];
        // 两指针分别指向左/右子数组的首个元素
        int i = 0;
        int j = m - l + 1; 

        for (int k = l; k <= r; k++) { // 遍历合并左/右子数组
            // 左子数组合并完成，添加右子数组
            if (i == m - l + 1)
                nums[k] = tmp[j++];
            // 右子数组合并完成，添加左子数组
            // 如果 左子数组<=有字数组，也添加左子数组
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            // 否则添加右子数组
            else {
                nums[k] = tmp[j++];
            }
        }
    }
}
