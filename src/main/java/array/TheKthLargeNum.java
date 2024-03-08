package array;

/**
 * @author: Tao
 * @Date: 2024/03/08 20:04
 * @Description: 215. 数组中的第K个最大元素
 */

public class TheKthLargeNum {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0) return;
        if (l >= r) return ;
        int i = l, j = r, x = nums[l + r >> 1];
        while(i < j) {
            while(nums[i] < x) i++;
            while(nums[j] > x) j--;
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, i, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,2,3,1};
        TheKthLargeNum instance = new TheKthLargeNum();
        System.out.println(instance.findKthLargest(nums, 2));
    }
}
