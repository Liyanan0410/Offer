package tx;

import java.util.ArrayList;
import java.util.List;

public class permute {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = fun(nums);
		for(List<Integer> Li : res) {
			for(Integer i : Li) {
				System.out.println(i);
			}
		}
	}

	public static List<List<Integer>> fun(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		backtrack(res, temp, nums);
		return res;
    }
	public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
		if(temp.size() == nums.length){
			res.add(new ArrayList<>(temp));
		}else {
			for(int i = 0; i < nums.length; i++) {
				if(temp.contains(nums[i])) continue;
				temp.add(nums[i]);
				backtrack(res, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}
}
