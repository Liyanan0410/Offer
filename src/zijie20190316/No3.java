package zijie20190316;

import java.util.Arrays;

public class No3 {
	public static void main(String[] args) {
		int n = 2;
		int[] nums = {1, 2};
		int num = fun(n, nums);
		System.out.println(num);
	}
	
	public static int fun(int n, int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		int[] res = new int[nums.length];
		res[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			if(i == nums.length-1) {
				if(nums[i] > nums[i-1]) {
					res[i] = res[i-1] + 1;
				}else if(nums[i] > nums[0]){
					res[i] = res[0] + 1;
				}else {
					res[i] = res[0];
				}
			}else if(nums[i] > nums[i-1]) {
				res[i] = res[i-1] + 1;
			}else {
				res[i] = res[i-1];
			}
		}
//		System.out.println(nums.length);
//		System.out.println(res.length);
//		for(int i = 0; i < nums.length; i++) {
//			System.out.println(res[i]);
//		}
		for(int i : res) {
			sum += i;
		}
		return sum;
	}
}
