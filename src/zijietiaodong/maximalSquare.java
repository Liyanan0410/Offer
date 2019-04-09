package zijietiaodong;

public class maximalSquare {
	public static int maximalSquareFun(char[][] matrix) {
	    int m = matrix.length;
	    if(m <= 0) {
	    	return 0;
	    }
	    int n = matrix[0].length;
	    if(n <= 0) {
	    	return 0;
	    }
	    int num = 0;
	    
	    int[][] res = new int[m][n];
	    for(int i = 0; i < m; i++) {
	    	res[i][0] = matrix[i][0]-'0';
	    	num = Math.max(num, res[i][0]);
	    }
	    for(int i = 0; i < n; i++) {
	    	res[0][i] = matrix[0][i]-'0';
	    	num = Math.max(num, res[0][i]);
	    }
	    for(int i = 1; i < m; i++) {
	    	for(int j = 1; j < n; j++) {
	    		if(matrix[i][j] == '1') {
	    			res[i][j] = Math.min(Math.min(res[i-1][j], res[i-1][j-1]), res[i][j-1]) + 1;
	    		}else {
	    			res[i][j] = 0;
	    		}
	    		num = Math.max(num, res[i][j]);
	    	}
	    }
	    return num*num;
	}
	
	public static void main(String[] args) {
		char[][] matrix = { {'1','0','1','0','0'},
							{'1','0','1','1','1'},
							{'1','1','1','1','1'},
							{'1','0','0','1','0'} };
		int res = maximalSquareFun(matrix);
		System.out.println(res);
		char[][] matrix2 = {};
		res = maximalSquareFun(matrix2);
		System.out.println(res);
	}
}
