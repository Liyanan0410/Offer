package zijie20190316;

import java.util.Arrays;

public class No4 {
	public static void main(String[] args) {
		int n = 2;
		int m = 4;
		int[] nums = {3, 5, 4};
		double res = fun(n, m, nums);
		System.out.println(String.format("%.2f", res));
	}
	
	public static double fun(int n, int m, int[] nums) {
		double ll = 0;
		
		Arrays.sort(nums);
		int length  = nums.length;
		double rr = nums[length-1];
		double mid = 0;
		while(ll < rr-0.001) {
			int ans = 0;
			mid = (ll+rr)/2;
			for(int i = 0; i < length&&nums[i] > mid; i++) {
				ans += nums[i]/mid;
			}
			if(ans >= m) {
				ll = mid;
			}else {
				rr = mid;
			}
		}
		return ll;
	}
}
