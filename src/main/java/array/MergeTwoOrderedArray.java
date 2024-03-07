package array;

import java.util.Arrays;

/**
 * @author: Tao
 * @Date: 2024/03/07 10:07
 * @Description:
 */

public class MergeTwoOrderedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] nums = new int[nums1.length];
        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        while(i < m) nums[k++] = nums1[i++];
        while(j < n) nums[k++] = nums2[j++];
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
        }
    }

    public static void main(String[] args) {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;
        MergeTwoOrderedArray instance = new MergeTwoOrderedArray();
        instance.merge(nums1, m ,nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


}
