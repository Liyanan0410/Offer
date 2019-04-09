package tx;

public class canWinNim {

	public static void main(String[] args) {
		System.out.println(fun(5));

	}
	public static boolean fun3(int n) {
		if(n%4 == 0)
			return false;
		return true;
	}
	public static boolean fun2(int n) {
		boolean[] dp = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(n%4 == 0) {
				dp[i] = false;
			}else
				dp[i] = true;
		}
		return dp[n-1];
	}
	
	public static boolean fun(int n) {
		boolean[] dp = new boolean[n];
		if(n <= 3) {
			return true;
		}
		for(int i = 0; i<3; i++) {
			dp[i] = true;
		}
		for(int i = 3; i<n; i++) {
			if(!(dp[i-1]&&dp[i-2]&&dp[i-3]))
				dp[i] = true;
			else
				dp[i] = false;
		}
        return dp[n-1];
    }
}
