import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        QuickSort qS = new QuickSort();
        qS.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int partitionIndex = partition(nums, left, right); // 获取基准元素的位置
        quickSort(nums, left, partitionIndex - 1); // 对左边部分进行快速排序
        quickSort(nums, partitionIndex + 1, right); // 对右边部分进行快速排序
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // 选择第一个元素作为基准元素
        int i = left;
        int j = right;
        while (i < j) {
            // 从右边找到第一个小于等于基准元素的位置
            while (i < j && nums[j] > pivot) {
                j--;
            }

            // 从左边找到第一个大于基准元素的位置
            while (i < j && nums[i] <= pivot) {
                i++;
            }

            // 交换这两个位置上的元素
            if (i < j) {
                swap(nums, i, j);
            }
        }

        // 将基准元素放到正确的位置
        swap(nums, left, i);
        return i; // 返回基准元素的位置
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }
}
