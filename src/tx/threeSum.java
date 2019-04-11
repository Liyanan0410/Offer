package tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> fun(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 先对数组进行排序，然后利用双指针进行两数之和。O(n*n)
        Arrays.sort(nums);
        // 注意：只有排序数组才可以利用下面的解法
        for (int i = 0; i < nums.length; i++) {
            // 对第一层元素去重(去重的目的是防止出现重复三元组结果.)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    // 对第二层元素去重处理
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }else if (sum > 0) {
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
