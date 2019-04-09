package tx;

public class reverseWords {

	public static void main(String[] args) {
		String s = new String("Let's take LeetCode contest");
		System.out.println(fun(s));
	}
	
	public static String fun(String s) {
		if(s.length() == 0) {
			return "";
		}
		String[] str = s.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			StringBuilder temp = new StringBuilder(str[i]);
			temp.reverse();
			if(i != 0) {
				res.append(" ").append(temp);
			}else {
				res.append(temp);
			}
		}
        return res.toString();
    }
}
