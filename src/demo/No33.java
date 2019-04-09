package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No33 {
//	�Ƚ�����ת�����ַ������飬Ȼ����ַ������鰴�չ�����������ź�����ַ�������ƴ�ӳ�����
//	�ؼ������ƶ��������
//
//	��ab > ba �� a > b
//	��ab < ba �� a < b
//	��ab = ba �� a = b
//	����˵����
//	a = 21
//	b = 2
//	��Ϊ 212 < 221, �� ab < ba ������ a < b
//	��������ͨ����ab��ba�Ƚϴ�С�����ж�a��ǰ����b��ǰ�ġ�
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
