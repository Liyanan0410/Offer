package zijietiaodong;

public class Profit {
	public static int maxProfit(int[] prices) {
		if(prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int min = prices[0];
		int max = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > min) {
				max = max > prices[i] - min ? max : prices[i] - min;
			}else {
				min = prices[i];
			}
		}
        return max;
    }
	
	public static void main(String[] args) {
		int[] prices={7, 1, 5, 3, 6, 4};
		int res = maxProfit(prices);
		System.out.println(res);
		int[] prices2={7, 6, 4, 3, 1};
		res = maxProfit(prices2);
		System.out.println(res);
	}
}
