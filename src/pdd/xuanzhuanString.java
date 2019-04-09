package pdd;

public class xuanzhuanString {

	public static void main(String[] args) {
		String str = "abcdabcd";
		fun(str);

	}
	
	public static void fun(String str) {
		int len = str.length();
		int k = len/4;
		System.out.println(str.substring(0, k+1));
		StringBuilder sd = new StringBuilder();
		for(int i = 0; i < k-1; i++) {
			sd.append(" ");
		}
		for(int i = 0; i < k-1; i++) {
			System.out.println(str.charAt(len-1-i) + sd.toString() + str.charAt(k+1+i));
		}
		sd = new StringBuilder(str.substring(2*k, 3*k+1));
		System.out.println(sd.reverse().toString());
	}

}
