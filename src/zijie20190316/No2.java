package zijie20190316;

public class No2 {

	public static void main(String[] args) {
		String str = "AAAABBBCC";
		String res = fun(str);
		System.out.println(res);
	}
	
	public static String fun(String str) {
		int length = str.length();
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < length; i++) {
			if(i+2 < length) {
				if(str.charAt(i) == str.charAt(i+1) && str.charAt(i+1) == str.charAt(i+2)) {
					continue;
				}else {
					res.append(str.charAt(i));
				}
			}else {
				res.append(str.charAt(i));
			}
			
		}
		int len = res.length();
		int j = 0;
		while(j+3 < len) {
			if(res.charAt(j) == res.charAt(j+1) && res.charAt(j+2) == res.charAt(j+3)) {
				res = res.deleteCharAt(j+2);
			}else {
				j++;
			}
		}
		return res.toString();
	}

}
