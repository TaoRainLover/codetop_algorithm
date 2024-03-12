package array;

import java.util.*;

/**
 * @author: Tao
 * @Date: 2024/03/12 14:16
 * @Description: 15. 三数之和
 */

public class ThreeIntegerSum {
    /*
    使用dfs+回溯+set判断重复List（超时）

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {

        for (int i = 0; i <= nums.length - 3; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(nums, list, i);
        }

        return res;
    }

    public void dfs(int[] nums, List<Integer> list, int i) {
        if (list.size() == 3 && sum(list) == 0) {

            if (!containsList(res, list)) {
                res.add(new ArrayList<>(list));
            };
        }
        if (list.size() < 3) {
            for (int j = i+1; j < nums.length; j++) {
                list.add(nums[j]);
                dfs(nums, list, j);
                // 回溯
                list.remove(list.size()-1);
            }
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static boolean containsList(List<List<Integer>> list, List<Integer> newList) {
        Set<Integer> set1 = new HashSet<>(newList);
        for (List<Integer> sublist : list) {
            Set<Integer> set2 = new HashSet<>(sublist);
            if (set1.equals(set2)) {
                return true; // newList already exists in the list
            }
        }
        return false; // newList does not exist in the list
    }

     */

    /**
     * 标准解法（来自GPT）
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // Skip duplicates
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeIntegerSum instance = new ThreeIntegerSum();
        List<List<Integer>> lists = instance.threeSum(nums, 0);
        System.out.println(lists.toString());
    }
}
