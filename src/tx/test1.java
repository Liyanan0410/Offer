package tx;

import java.util.Arrays;
import java.util.Scanner;

//硬币问题
public class test1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int numMoney = scan.nextInt();
        int nums = scan.nextInt();
        int[] prices = new int[nums];
        int[] count = new int[nums];
        for (int i = 0; i < nums; i++) {
        	prices[i] = scan.nextInt();
        	count[i] = 0;
        }
        Arrays.sort(prices);
        System.out.println(fun(numMoney, count, prices));
        scan.close();
	}
	
	public static int fun(int numMoney, int[] count, int[] prices) {
		//修改了
		if(prices[0] != 1) {
			return -1;
		}
		int index = 0;
		int countMoney = 0;
		for(int i = 1; i<= numMoney; i++) {
			index = find(i, prices);
			if(countMoney < i) {
				count[index]++;
				countMoney += prices[index];
			}
			System.out.print(i + " ");
			for(int j =0; j < count.length; j++) {
				if(j != count.length-1) {
					System.out.print(count[j] + " ");
				}else {
					System.out.println(count[j]);
				}
			}
		}
		int res = 0;
		for(int m : count) {
			res += m;
		}
		return res;
	}
	
	//返回的都是下标
	//修改了
	//太慢了，可以折半
	public static int find(int numMoney, int[] prices) {
		for(int i = prices.length-2; i >=0; i--) {
			if(!(numMoney<prices[i]) && !(numMoney>prices[i+1]))
				return i;
		}
		return prices.length-1;
	}
}
