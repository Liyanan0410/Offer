package zijietiaodong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class maxEnvelopes {
	public int maxEnvelopesFun(int[][] envelopes) {
		int length = envelopes.length;
		if(length <= 0) {
			return 0;
		}
		List<Rectangle>rec = new ArrayList<Rectangle>();
		for(int[] env : envelopes) {
			rec.add(new Rectangle(env[0], env[1]));
		}
//		Arrays.sort(envelopes, (a,b) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
		
		Collections.sort(rec, new Comparator<Rectangle>() {
			@Override
			public int compare(Rectangle r1, Rectangle r2) {
				if(r1.width != r2.width)
					return r1.width - r2.width;
				else
					return r1.heigth - r2.heigth;
			}
		});
		int[] dp = new int[length];
		int max = 1;
		Arrays.fill(dp, 1);
		for(int i = 1; i < rec.size(); i++) {
			for(int j = 0; j < i; j++) {
				if(rec.get(i).width > rec.get(j).width && rec.get(i).heigth > rec.get(j).heigth) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
        return max;
    }
//	内存更小，耗时更多
	 public int maxEnvelopes2(int[][] envelopes) {
	        int length = envelopes.length;
			if(length <= 0) {
				return 0;
			}
	        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
			int[] dp = new int[length];
			int max = 1;
			Arrays.fill(dp, 1);
			for(int i = 1; i < length; i++) {
				for(int j = 0; j < i; j++) {
					if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
				max = Math.max(max, dp[i]);
			}
	        return max;
	    }
}

class Rectangle {
	int width;
	int heigth;
	public Rectangle (int width, int heigth) {
		this.width = width;
		this.heigth = heigth;
	}
}
