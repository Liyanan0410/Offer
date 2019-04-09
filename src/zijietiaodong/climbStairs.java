package zijietiaodong;

public class climbStairs {
	public static int climbStairsFun(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		int[] res = new int[n];
		res[0] = 1;
		res[1] = 2;
		for(int i = 2; i < n; i++) {
			res[i] = res[i-1] + res[i-2];
		}
		
        return res[n-1];
    }
	public static void main(String[] args) {
		int n = 2;
		int res = climbStairsFun(4);
		System.out.println(res);
	}
}
