package tx;

import java.util.Scanner;

//01 10 Œ Ã‚
public class test2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        String string = scan.nextLine();
        while(string.contains("01")||string.contains("10")) {
            string =string.replaceAll("01", "");
            string =string.replaceAll("10", "");
        }       
        System.out.println(string.length());
        scan.close();
	}

}
