package zijietiaodong;

public class longestPalindrome {
	//暴力
	public static String longestPalindromeFun(String s) {
		if(s.isEmpty()){
            return s;
        }
        String res=s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String k=s.substring(i,j);
                String rk=new StringBuffer(k).reverse().toString();
                if(k.equals(rk)&&k.length()>res.length()){
                    res=k;
                }
            }

        }
        return res;
    }
	
	//动态规划
	public static String longestPalindromeFun2(String s) {
		if(s.isEmpty()){
            return s;
        }
        String res = s.substring(0, 1);
        
        int length = s.length();
        int L = 0;
//        int max = 1;
        int[][] dp = new int[length][length];
        for(int i = 0; i < length; i++) {
        	dp[i][i] = 1;
//        	res = (i == length-1 && max == 1) ? s.substring(i, i+1) : res;
        	int j = i+1;
        	if(j < length && s.charAt(i) == s.charAt(j)) {
        		dp[i][j] = 1;
        		res = s.substring(i, j+1);
//        		max = j-i+1;
        	}else if(j < length){
        		dp[i][j] = 0;
        	}
        }
        
        for(L = 3; L <= length; L++){
        	for(int i = 0; L+i-1 < length; i++) {
        		int j = L+i-1;
        		if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
        			dp[i][j] = 1;
//        			max = L;
        			res = s.substring(i, j+1);
        		}else {
        			dp[i][j] = 0;
        		}
        	}
        }
        return res;
    }
	
	public static String longestPalindromeFun3(String s) {
        int n = s.length();
        if(n==0 || s==null)
            return s;
        String reString = null;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i >= 0; i--) {
            for(int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i)==s.charAt(j)&&(j-i<3 || dp[i+1][j-1]);    //判断是否为回文串
                if(dp[i][j] && (reString==null || reString.length()<j-i+1))//判断这个回文串的长度是否大于最长长度
                    reString = s.substring(i,j+1);
            }
        }
        return reString;
    }
	
	public static void main(String[] args) {
		String s = "ccc";
		String res = longestPalindromeFun3(s);
		System.out.println(res);
	}
}
