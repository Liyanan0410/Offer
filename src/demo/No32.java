package demo;

public class No32 {
	//依次遍历每个数，判断每个数里面是否包含1
	public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++)
            res += number1(i);
        return res;
    }

    public int number1(int n){
        int res = 0;
        while(n>0){
            if(n % 10 == 1)
                res++;
            n /= 10;
        }
        return res;
    }
    
    //同法一，将数字转成字符串，直接判断
    public int NumberOf1Between1AndN_Solution2(int n) {
        int res = 0;
        StringBuffer s = new StringBuffer();
        for(int i = 1; i<=n; i++){
            s.append(i);
        }
        String str = s.toString();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1')
                res++;
        }
        return res;
    }
    
    //归纳法
//  设N = abcde ,其中abcde分别为十进制中各位上的数字。
//	如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（
//	高位）的数字。
//	① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：
//	100~199，1100~1199,2100~2199，，…，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，并且
//	等于更高位数字（12）乘以 当前位数（100）。
//	② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受
//	高位影响出现的情况是：100~199，1100~1199,2100~2199，，….，11100~11199，一共1200个。和上面情况一样，
//	并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一
//	共114个，等于低位数字（113）+1。
//	③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,
//	1100~1199，2100~2199，…，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数
//	（100）。
    public int NumberOf1Between1AndN_Solution3(int n) {
        int res = 0;
        int cur = 0, before = 0, after = 0;
        int i = 1;
        while(i<=n){
            before = n/(i*10);
            cur = (n/i)%10;
            after = n - n/i*i;
            if(cur == 0){
                // 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                res += before * i;
            }else if(cur == 1){
                // 如果为1, 出现1的次数由高位和低位决定,高位*当前位+低位+1
                res += before * i + after + 1;
            }else{
                // 如果大于1, 出现1的次数由高位决定,（高位数字+1）* 当前位数
                res += (before + 1) * i;
            }
            i *= 10;
        }
        return res;
    }
}
