package tx;

public class merge {

	public static void main(String[] args) {
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;
		nums1 = fun(nums1, m, nums2, n);
		for(int i : nums1) {
			System.out.println(i);
		}
		
	}
	public static int[] fun(int[] nums1, int m, int[] nums2, int n) {
		if(m == 0){
			nums1 = nums2;
			return nums1;
		}
		if(n == 0) {
			return nums1;
		}
//        int[] res = new int[m+n];
        int indexM = m-1;
        int indexN = n-1;
        while(indexM >=0 && indexN >=0) {
        	if(nums1[indexM] <= nums2[indexN]) {
        		nums1[indexM+indexN+1] = nums2[indexN];
        		indexN--;
        	}else {
        		nums1[indexM+indexN+1] = nums1[indexM];
        		indexM--;
        	}
        }
        
        return nums1;
    }
}
