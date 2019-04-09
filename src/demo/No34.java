package demo;

public class No34 {
//	我们只求丑数，不要去管非丑数。每个丑数必然是由小于它的某个丑数乘以2，3或5得到的，这样我们把求得的丑数都保存下
//	来，用之前的丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个我们要求的丑数。这种方
//	法用空间换时间，时间复杂度为O(n)。
	public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        if(index == 1)
            return 1;
        int t2 = 0, t3 = 0, t5 = 0;
        int [] res = new int[index];
        res[0] = 1;
        for(int i = 1; i<index; i++){
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5]*5));
            if(res[i] == res[t2]*2) t2++;
            if(res[i] == res[t3]*3) t3++;
            if(res[i] == res[t5]*5) t5++;
        }
        return res[index-1];
    }
}
