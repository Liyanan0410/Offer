package zijietiaodong;

public class maxSubArray {
	public int maxSubArrayFun(int[] nums) {
		int res = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(res <= 0) {
				res = nums[i];
			}else {
				res = res + nums[i];
			}
			if(res > max) {
				max = res;
			}
		}
        return max;
    }
}
