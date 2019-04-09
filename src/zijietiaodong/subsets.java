package zijietiaodong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
	public static List<List<Integer>> subsetsFun(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int length = nums.length;
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		if(length == 0) {
			return res;
		}
		for(int i = 0; i < length; i++) {
			int size = res.size();
			for(int j = 0; j < size; j++) {
				List<Integer> subset = new ArrayList<>(res.get(j));
				subset.add(nums[i]);
				res.add(subset);
			}
		}
		return res;
    }
//	超时的结果
	public List<List<Integer>> subsetsError(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		int length = nums.length;
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		if(length == 0) {
			return res;
		}
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < res.size(); j++) {
				res.add(res.get(j));
				res.get(j).add(nums[i]);
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] nums = {1, 2, 3};
		res = subsetsFun(nums);
		System.out.println(res);
	}
}
