package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No33 {
//	先将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序的字符串数组拼接出来。
//	关键就是制定排序规则：
//
//	若ab > ba 则 a > b
//	若ab < ba 则 a < b
//	若ab = ba 则 a = b
//	解释说明：
//	a = 21
//	b = 2
//	因为 212 < 221, 即 ab < ba ，所以 a < b
//	所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。
	public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if(len == 0)
            return "";
        if(len == 1)
            return String.valueOf(numbers[0]);
        StringBuffer res = new StringBuffer();
        String [] str = new String[len];
        for(int i=0; i<len; i++)
            str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i=0; i<len; i++)
            res.append(str[i]);
        return res.toString();
    }
}
