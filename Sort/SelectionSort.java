import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
        SelectionSort sS = new SelectionSort();
        sS.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void selectSort(int[] nums) {
        /**
         * 选择排序是一种简单的排序算法，其基本思想是每一次从待排序的元素中选择最小（或最大）的元素，然后与待排序序列的第一个元素交换位置，从而逐步形成有序序列。
         * 具体的步骤如下：
         *
         * 1. 首先，从待排序序列中找到最小（或最大）的元素，记为最小元素。
         * 2. 将最小元素与待排序序列的第一个元素交换位置，即将最小元素放在待排序序列的最前面。
         * 3. 然后，在剩余的未排序元素中找到最小（或最大）的元素，再将其与待排序序列的第二个元素交换位置，即将第二小（或第二大）元素放在待排序序列的第二个位置。
         * 4. 依此类推，直到所有元素都排序完成。
         *
         * 选择排序的特点是每一轮都确定了一个元素的最终位置，因此可以看作是一种不稳定的排序算法。
         * 它的时间复杂度为O(n^2)，其中n是待排序序列的长度。
         * 尽管选择排序的时间复杂度较高，但由于其简单的思想和易于实现的特点，对于小规模的数据排序是一种较为合适的选择。
         */
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }

            if (i != min) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }
}
