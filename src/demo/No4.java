package demo;

public class No4 {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We are happy.");
		String res = replaceSpace(str);
		System.out.println(res);
	}
	
    public static String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
        	if(i == len)
        		System.out.println(str.charAt(i));
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }
}
