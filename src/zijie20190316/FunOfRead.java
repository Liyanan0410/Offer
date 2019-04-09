package zijie20190316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FunOfRead {

	public static void main(String[] args) {
		FunOfScanner();
	}
	
	//���뵥���ַ�
	public static void single() {
		char s = '0';
		try {
			s = (char)System.in.read();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("��������ݣ�" + s);
	}
	
	//�����������
	public static void FunOfScanner() {
		System.out.print("���룺");
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
			System.out.println("���������" + num);
		}
	}
	
	public static void FunOfBuffered() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rd = "";
		System.out.print("���룺");
		try {
			rd = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("��������ݣ�" + rd);
	}
}
