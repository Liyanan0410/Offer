package tx;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

	public static void main(String[] args) {
		int n = 3;
		List<String> res = fun(n);
		for(String str : res) {
			System.out.println(str);
		}
	}

	public static List<String> fun(int n) {
		List<String> res = new ArrayList<String>();
		StringBuilder sd = new StringBuilder("");
		int left = n;
		int right = n;
		backtrack(res, sd, left, right);
		
		return res;
        
    }
	private static void backtrack(List<String> res, StringBuilder sd, int left, int right) {
		if(left > right) {
			return;
		}
		if(left>0) {
			backtrack(res, sd.append("("), left-1, right);
			sd.deleteCharAt(sd.length()-1);
		}
		if(right>0) {
			backtrack(res, sd.append(")"), left, right-1);
			sd.deleteCharAt(sd.length()-1);
		}
		if(left==0&&right==0) {
			res.add(sd.toString());
			return;
		}
	}
}
