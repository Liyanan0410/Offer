package pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//最长递增子串
public class lis {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = scan.nextInt();
//		}
//		int[] dp = new int[n];
//		int max = 0;
//		for(int i = 0; i < n; i++) {
//			int maxTemp = 0;
//			for(int j = 0; j < i; j++) {
//				if(arr[i] > arr[j]) {
//					maxTemp = maxTemp > dp[j] ? maxTemp : dp[j];
//				}
//			}
//			dp[i] = maxTemp+1;
//			max = max > dp[i] ? max : dp[i];
//		}
//		System.out.println(max);
//		scan.close();
		int[] nums = {4,10,4,3,8,9};
		System.out.println(lengthOfLIS(nums));
	}
	
	public static int lengthOfLIS(int[] nums) {
		
		int length  = nums.length;
		if(length == 0) {
			return 0;
		}
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(nums[0]);
		int maxL = 0;
		for(int i = 1; i < length; i++) {
			if(dp.get(maxL) < nums[i]) {
				dp.add(nums[i]);
				maxL++;
			}
			if(dp.get(maxL) > nums[i] && !dp.contains(nums[i])) {
				int index = search(dp, nums[i], 0, maxL);
				dp.set(index, nums[i]);
			}
		}
		return maxL+1;
	}
	
	static int search(List<Integer> dp, int x,int l,int r)
	{            //二分查找找到一个位置，使得x>dp[i-1], 并且x<dp[i],并用x代替dp[i] 
	   int m;
	   while(l<=r){
	       m=(l+r)>>1;
	       if(x>=dp.get(m))
	    	   l=m+1;
	       else
	    	   r=m-1;
	    }
	    return l;
	 }
}
