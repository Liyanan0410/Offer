package demo;
import java.util.ArrayList;
import java.util.HashMap;

public class No41_1 {
//	��ϣ������һ��HashMap������ key �洢��S��������ÿ�����Ĳvalue �洢��ǰ�����֣��Ƚ�S=15, ��
//	ǰ����Ϊ 4������ hashmap �в���(key=11, value=4)�����Ǳ������飬�ж�hashmap �е� key �Ƿ����
//	��ǰ�����֣�������ڣ�˵����������һ�����뵱ǰ������Ӻ�Ϊ S�����ǾͿ����ж����ǵĳ˻��Ƿ�С��֮
//	ǰ�ĳ˻������С�Ļ����滻֮ǰ���ҵ������֣������ͷ�����ǰ�ҵ��ġ����hashmap �е� key ������
//	��ǰ�����֣�˵����û���ҵ���Ӻ�Ϊ S �����������ǾͰ�S�뵱ǰ���ֵĲ���Ϊ key����ǰ������Ϊ value 
//	���뵽 hashmap �У�����������
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(array.length < 2)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int less = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                if(array[i] * map.get(array[i]) < less){
                    less = array[i] * map.get(array[i]);
                    res.clear();
                    res.add(map.get(array[i]));
                    res.add(array[i]);
                }
            }else{
                int key = sum - array[i];
                map.put(key, array[i]);
            }
        }
        return res;
    }
//	���ҼбƵķ�����a+b=sum��a��bԽԶ�˻�ԽС����Ϊ�����ǵ�����������һͷһβ����ָ�����ڿ����ķ����ҵ��ľ���
//	�˻���С�����
//	��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС��
//	��ai + aj > sum��˵�� aj ̫���ˣ�j ��
//	��ai + aj < sum��˵�� ai ̫С�ˣ�i ++
	public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(array.length < 2)
            return res;
        int i = 0, j = array.length - 1;
        while(i != j){
            if(array[i] + array[j] == sum){
                res.add(array[i]);
                res.add(array[j]);
                break;
            }else if(array[i] + array[j] < sum){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
