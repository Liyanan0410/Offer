package zijie20190316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FunOfRead {

	public static void main(String[] args) {
		FunOfScanner();
	}
	
	//读入单个字符
	public static void single() {
		char s = '0';
		try {
			s = (char)System.in.read();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("输入的数据：" + s);
	}
	
	//按照需求读入
	public static void FunOfScanner() {
		System.out.print("输入：");
		int index = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n+1];
		while(true) {
			nums[index] = scan.nextInt();
			index++;
			if(index == n) {
				break;
			}
		}		
		for(int num : nums) {
			System.out.println("输入的数据" + num);
		}
	}
	
	public static void FunOfBuffered() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rd = "";
		System.out.print("输入：");
		try {
			rd = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("输入的数据：" + rd);
	}
}
