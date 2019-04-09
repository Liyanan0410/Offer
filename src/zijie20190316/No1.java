package zijie20190316;

import java.util.Scanner;

public class No1 {
	public static void main(String[] args) {
		int num = 1024;
		int ans = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int res = num - n;
		
		ans += res/64;
		res = res%64;
		ans += res/16;
		res = res%16;
		ans += res/4;
		res = res%4;
		ans += res/1;
		res = res%1;
		System.out.println(ans);
	}
}
