package pdd;

public class youqudebianhuan {

	public static void main(String[] args) {
		String str = "00011";
		int res = fun(str);
		System.out.println(res);

	}
	
	public static int fun(String str) {
		int len = str.length();
		int count = 0;
		for(int i = 0; i < len-1; i++) {
			int left = judge(str, 0, i);
			if(left == 0)
				continue;
			int right = judge(str, i+1, len-1);;
			count += left*right;
		}
		return count;
	}
	
	static int judge(String str, int start, int end) {
		if(start == end)
			return 1;
		if(str.charAt(start) == '0' && str.charAt(end) == '0')
			return 0;
		if(str.charAt(start) == '0' || str.charAt(end) == '0')
			return 1;
		return end - start + 1;
	}

}
