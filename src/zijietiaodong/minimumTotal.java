package zijietiaodong;
import java.util.Arrays;
import java.util.List;

public class minimumTotal {
	public static int minimumTotalFun(List<List<Integer>> triangle) {
		int length  = triangle.size();
		if(length == 0) {
			return 0;
		}
		int[] memo = new int[length];
		for(int i = 0; i < length; i++) {
			memo[i] = triangle.get(length-1).get(i);
		}
		for(int j = length-2; j >= 0; j--) {
			for(int i = 0; i <= j; i++) {
				memo[i] = triangle.get(j).get(i) + Math.min(memo[i], memo[i+1]);
			}
		}
		
        return memo[0];
    }
	
	public static int minimumTotalFun2(List<List<Integer>> triangle) {
		int length  = triangle.size();
		if(length == 0) {
			return 0;
		}
		int[][] memo = new int[length][length];
		memo[0][0] = triangle.get(0).get(0);
		
		for(int j = 1; j < length; j++) {
			for(int i = 0; i <= j; i++) {
				if(i == 0) {
					memo[j][i] = memo[j-1][0] + triangle.get(j).get(i);
				}
				else if(i == j) {
					memo[j][i] = memo[j-1][j-1] + triangle.get(j).get(i);
				}
				else {
					memo[j][i] = triangle.get(j).get(i) + Math.min(memo[j-1][i-1], memo[j-1][i]);
				}
				
			}
		}
		
		int res = memo[length-1][0];
		for(int i = 1; i < length; i++) {
			res = memo[length-1][i] > res ? res : memo[length-1][i];
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(2);
		List<Integer> b = Arrays.asList(3, 4);
		List<Integer> c = Arrays.asList(6, 5, 7);
		List<Integer> d = Arrays.asList(4, 1, 8, 3);
		List<List<Integer>> triangle = Arrays.asList(a, b, c, d);
		int res = minimumTotalFun2(triangle);
		System.out.println(res);
	}
}
