package demo;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class No29 {
	//����hashmap�洢������ÿ�������ֵĴ���������Ƿ������ֳ��ִ����������鳤�ȵ�һ��
    public int MoreThanHalfNum_Solution1(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = array.length;
        for(int i=0; i<length; i++){
            if(!map.containsKey(array[i]))
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i])+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()*2>length)
                return entry.getKey();
        }
        return 0;
    }
    
    //����������������ĳ�����ֳ��ִ�����������ĳ��ȵ�һ�룬��һ���������м��λ�á���������ȡ��������м�λ��
    //������ͳ��һ�����ĳ��ִ����Ƿ�������鳤�ȵ�һ�룻
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int half = array.length/2;
        int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == array[half])
                count ++;
        }
        if(count > half)
            return array[half];
        else
            return 0;
    }
    //ĳ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬��˼���������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ������ǿ�����
    //���������ʱ���¼����ֵ��1. �����е�����;2. ������������һ������ʱ��������֮ǰ�����������ͬ���������1��
    //���������1��������Ϊ0���򱣴���һ�����֣�
    //����������Ϊ1����������������������ּ�Ϊ����������ж����Ƿ��������
    public int MoreThanHalfNum_Solution3(int [] array) {
        int res = array[0], count = 1;
        for(int i=1; i<array.length; i++){
            if(array[i] == res)
                count++;
            else{
                count--;
            }
            if(count == 0){
                res = array[i];
                count = 1;
            }
        }
        count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == res)
                count++;
        }
        return count > array.length/2 ? res : 0;
    }
}
