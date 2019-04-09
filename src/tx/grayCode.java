package tx;

import java.util.ArrayList;
import java.util.List;

public class grayCode {

	public static void main(String[] args) {
		int n = 10;
		List<Integer> res = f(n);
		for(Integer i : res) {
			System.out.println(i);
		}

	}
	public static List<Integer> f(int n) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i< 1<<n; i++) {
			res.add(i^i>>1);
		}
		return res;
	}
	public static List<Integer> fun(int n) {
        List<Integer> res = new ArrayList<>();
        backtrack(res, n);
        return res;
    }
	public static void backtrack(List<Integer> res, int n) {
		res.add(0);
		if(res.size() == Math.pow(2, n)) {
			return;
		}else {
			for(int i = 1; i < Math.pow(2, n); i++) {
				if(res.contains(i))continue;
				if(Integer.bitCount(i^res.get(res.size()-1)) != 1)continue;
				res.add(i);
				i=1;
			}
		}
	}
}
