package tx;

import java.util.HashMap;

public class containsDuplicate {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(fun(nums));

	}
	public static boolean fun(int[] nums) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(res.containsKey(nums[i])) {
				return true;
			}else {
				res.put(nums[i], 1);
			}
		}
        return false;
    }
}
