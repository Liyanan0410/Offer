package zijietiaodong;

public class isMatch {
	//超出时间限制
	public static boolean isMatchFun(String s, String p) {
		if(s.isEmpty() && p.isEmpty()) {
			return true;
		}
		if(!s.isEmpty() && p.isEmpty()) {
			return false;
		}
		if(s.isEmpty() && !p.isEmpty()) {
			if(p.length() == 1) {
				return false;
			}else if(p.length() > 1 && !p.substring(1, 2).equals("*")) {
				return false;
			}else if(p.length() > 1 && p.substring(1, 2).equals("*")) {
				return isMatchFun(s, p.substring(2));
			}
			
		}
		if(!s.isEmpty() && p.isEmpty()) {
			return false;
		}
		if(p.length() > 1 && p.substring(1, 2).equals("*")) {
//			if(s.isEmpty()) {
//				return isMatchFun(s, p.substring(2));
//			}
			if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
				return isMatchFun(s.substring(1), p) ||
						isMatchFun(s.substring(1), p.substring(2)) ||
						isMatchFun(s, p.substring(2));
			}else{
				return isMatchFun(s, p.substring(2));
			}
		}
		
		if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
			return isMatchFun(s.substring(1), p.substring(1));
		}
		
        return false;
    }
	
	public static boolean isMatchFun2(String s, String p) {
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		if(p.length() == 1) {
			return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		}
		if(p.charAt(1) != '*') {
			if(s.isEmpty()) {
				return false;
			}else {
				return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
						isMatchFun2(s.substring(1), p.substring(1));
			}
		}
		while(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if(isMatchFun2(s, p.substring(2))) {
				return true;
			}else {
				s = s.substring(1);
			}
		}
		return isMatchFun2(s, p.substring(2));
	}
	
	public static boolean isMatchFun3(String s, String p) {
		if (p.length() <= 0) return s.length() <= 0;
	    boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
	    if (p.length() > 1 && p.charAt(1) == '*'){
	        return isMatchFun3(s, p.substring(2)) || (match && isMatchFun3(s.substring(1), p));
	    } else {
	        return match && isMatchFun3(s.substring(1), p.substring(1));
	    }
	}
	
	public static void main(String[] args) {
		String s = "ab";
		String p = ".*c";
		boolean res = isMatchFun(s, p);
		System.out.println(res);
	}
}
