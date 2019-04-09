package tx;

import java.util.Arrays;

public class findKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int fun(int[] nums, int k) {
		Arrays.sort(nums);
        return k > nums.length ? -1 : nums[nums.length-k+1];
    }
}
