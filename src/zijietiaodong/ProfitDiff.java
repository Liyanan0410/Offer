package zijietiaodong;

public class ProfitDiff {
	public static int maxProfitDiff(int[] prices) {
		if(prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int max= 0;
		for(int i = 1; i < prices.length; i++) {
			int temp = prices[i] - prices[i-1];
			if(temp > 0) {
				max = temp + max;
			}
		}
		return max;
	}

	public static int maxProfitDiff2(int[] prices, int k) {
		if(prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int a[] = prices;
		int b[] = func1(a);
		return func2(b, k);
	}
	
	public static int func2(int b[], int k) {
		int sum = 0;
		for(int i = 0; i < k && b[i] != -1; i++) {
			sum += b[i];
		}
		return sum;
	}
	
	public static int[] func1(int a[]) {
		
		int[] b = new int[a.length];
		for(int i = 0; i < b.length; i++) {
			b[i] = -1;
		}
		int k = 0;
		
		int i = 0;
		while(i < a.length - 1) {
			int j = i;
			
			while(j < a.length - 1 && a[j] < a[j + 1]) {
				j++;
			}
			if(j == i) {
				i++;
			} else {
				b[k] = a[j] - a[i];
				k++;
				i = j + 1;
			}
			
			
		}
		sortFun(b);
		
		return b;
	}
	
	public static void sortFun(int a[]) {
		int n = a.length; 
		 
	    for (int i = 0; i < n - 1; i++) { 
	      for (int j = 0; j < n - 1; j++) { 
	        if (a[j] < a[j + 1]) {
	          int temp = a[j]; 
	          a[j] = a[j + 1]; 
	          a[j + 1] = temp; 
	        }
	      }
	    }
	}
	
	public static void main(String[] args) {
		int[] prices={7, 1, 5, 3, 6, 4};
		int res = maxProfitDiff(prices);
		System.out.println(res);
		int[] prices2={1, 2, 3, 4, 5};
		res = maxProfitDiff(prices2);
		System.out.println(res);
	}
}
