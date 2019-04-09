package tx;

import java.util.Arrays;

public class threeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int fun(int[] nums, int target) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int a = 0;
		int absa = 0;
		int sum = 0;
		for(int i = 1; i< nums.length; i++) {
			int left = 0;
			int right = nums.length-1;
			while(left<i && right>i) {
				a = nums[i] + nums[left] + nums[right] - target;
				absa = Math.abs(a);
				if(min > absa) {
					min = absa;
					sum = nums[i] + nums[left] + nums[right];
				}
				
				if(a>0) {
					right--;
				}else if (a < 0)
					left++;
				else {
					sum = nums[i] + nums[left] + nums[right];
					break;
				}	
			}
		}
        return sum; 
    }

}
