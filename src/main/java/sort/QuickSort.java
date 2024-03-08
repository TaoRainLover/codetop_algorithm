package sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: Tao
 * @Date: 2024/03/08 18:40
 * @Description: 快速排序
 */

public class QuickSort {
    /* 20240308 - 存在超时问题
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[l];
        int i = l+1, j = r;
        while(i <= j) {
            while(i <= j && nums[i] <= x) i++;
            while(j >= i && nums[j] >= x) j--;
            if (i < j) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[i-1];
        nums[i-1] = nums[l];
        nums[l] = tmp;
        // 递归
        quickSort(nums, l, i-2);
        quickSort(nums, i, r);
    }

     */
   /*  GPT 生成*/
    public static void quickSort(int[] arr, int low, int high) {
        while(arr == null || arr.length == 0) return ;
        if (low >= high) return;
        int mid = low + high >> 1;
        int i = low, j = high, x = arr[mid];
        while (i < j) {
            while(arr[i] < x) i++;
            while(arr[j] > x) j--;
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if (high > i) quickSort(arr, i, high);
        if (j > low) quickSort(arr, low, j);
    }


    /* acwing
    public static void quickSort(int[] nums, int l ,  int r) {
        if (l >= r) return ;

        int i = l-1, j = r+1;
        int x = nums[l + r >> 1];
        while(i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }


        quickSort(nums, l, j);
        quickSort(nums, j+1, r);
    }

     */



    public static void main(String[] args) {
        // int[] arr = new int[]{5,1,1,2,0,0};
        int[] arr = new int[]{5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
