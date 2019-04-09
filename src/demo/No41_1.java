package demo;
import java.util.ArrayList;
import java.util.HashMap;

public class No41_1 {
//	哈希法。用一个HashMap，它的 key 存储数S与数组中每个数的差，value 存储当前的数字，比较S=15, 当
//	前的数为 4，则往 hashmap 中插入(key=11, value=4)。我们遍历数组，判断hashmap 中的 key 是否存在
//	当前的数字，如果存在，说明存在着另一个数与当前的数相加和为 S，我们就可以判断它们的乘积是否小于之
//	前的乘积，如果小的话就替换之前的找到的数字，如果大就放弃当前找到的。如果hashmap 中的 key 不存在
//	当前的数字，说明还没有找到相加和为 S 的两个数，那就把S与当前数字的差作为 key，当前数字作为 value 
//	插入到 hashmap 中，继续遍历。
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
//	左右夹逼的方法。a+b=sum，a和b越远乘积越小，因为数组是递增排序，所以一头一尾两个指针往内靠近的方法找到的就是
//	乘积最小的情况
//	若ai + aj == sum，就是答案（相差越远乘积越小）
//	若ai + aj > sum，说明 aj 太大了，j —
//	若ai + aj < sum，说明 ai 太小了，i ++
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
