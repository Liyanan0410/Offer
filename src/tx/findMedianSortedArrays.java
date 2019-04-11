package tx;

import java.util.ArrayList;
import java.util.List;

public class findMedianSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,1,1};
		int[] nums2 = {1,1,1};
		double res = fun(nums1, nums2);
		System.out.println(res);
	}

	public static double fun(int[] nums1, int[] nums2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		if(nums1.length ==0 && nums2.length ==0) {
			return 0.0;
		}
		if(nums1.length !=0) {
			for(int i = 0; i<nums1.length; i++) {
				list1.add(nums1[i]);
			}
		}
		if(nums2.length !=0) {
			for(int i = 0; i<nums2.length; i++) {
				list2.add(nums2[i]);
			}
		}
		if(list1.size() ==0) {
			return find(list2);
		}
		if(list2.size() ==0) {
			return find(list1);
		}
		
		while(list1.size()!=1 || list2.size()!=1) {
			if(list1.get(0) < list2.get(0)) {
				list1.remove(0);
			}else
				list2.remove(0);
			
			if(list1.size()==0) {
				list2.remove(list2.size()-1);
				break;
			}
			if(list2.size()==0) {
				list1.remove(list1.size()-1);
				break;
			}
			
			if(list1.get(list1.size()-1) > list2.get(list2.size()-1)) {
				list1.remove(list1.size()-1);
			}else
				list2.remove(list2.size()-1);
			
			if(list1.size()==0 || list2.size()==0)break;
		}
		if(list1.size() == 0) {
			return find(list2);
		}else if(list2.size() == 0) {
			return find(list1);
		}else {
			return (list1.get(0)+list2.get(0)) / 2.0;
		}		
    }
	
	public static double find(List<Integer> list) {
		int length = list.size();
		if(length == 0) {
			return 0.0;
		}
		double res = 0;
		if(length % 2 == 0) {
			res = (list.get(length/2) + list.get(length/2-1)) / 2.0;
		}else {
			res = list.get(length/2);
		}
		return res;
	}
}
