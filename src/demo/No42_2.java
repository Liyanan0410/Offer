package demo;

public class No42_2 {
	public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0)
            return "";
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1+s2;
    }
}
