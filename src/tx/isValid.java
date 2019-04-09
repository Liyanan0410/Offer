package tx;

import java.util.HashMap;
import java.util.Stack;

public class isValid {

	public static void main(String[] args) {
		System.out.println(fun("[])"));

	}
	public static boolean fun(String s) {
		Stack symbol = new Stack<>();
		HashMap hashmap = new HashMap<>();
		hashmap.put('(', ')');
		hashmap.put('{', '}');
		hashmap.put('[', ']');
		if(s.length() == 0) {
			return true;
		}
		if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
			return false;
		}
		symbol.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(symbol.size() == 0 && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
				return false;
			}
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				symbol.push(s.charAt(i));
			}else if(hashmap.get(symbol.peek()).equals(s.charAt(i))) {
				symbol.pop();
			}else {
				return false;
			}
		}
        return symbol.size() == 0;
    }
}
