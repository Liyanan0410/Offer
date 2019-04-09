package demo;
import java.util.ArrayList;

public class No41_2 {
//	滑动窗口的方法：用两个数字 start 和 end 分别表示序列的最小值和最大值，首先将 start 初始化为1，
//	end 初始化为2。如果从start到end的和大于sum，我们就从序列中去掉较小的值(即增大start),
//	相反，只需要增大end。
//	终止条件为：一直增加begin到(1+sum)/2并且end小于sum为止
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(sum < 3)
           return res;
        int start = 1, end = 2, mid = (1+sum)/2;
        while(start < mid){
            int s = totalSum(start, end);
            if(s == sum){
                res.add(getSequence(start, end));
                end ++;
            }else if(s < sum){
                end ++;
            }else if(s > sum){
                start ++;
            }
        }
        return res;
    }
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(sum < 3)
           return res;
        int start = 1, end = 2, mid = (1+sum)/2;
        int s = start + end;
        
        while(start < mid){
            if(s == sum){
                res.add(getSequence(start, end));
                end ++;
            }else if(s < sum){
            	
                end ++;
                s += end;
            }else if(s > sum){
            	s -= start;
                start ++;
            }
        }
        return res;
    }
	
    public int totalSum(int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }

    public ArrayList<Integer> getSequence(int start, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = start; i <= end; i++){
            temp.add(i);
        }
        return temp;
    }
}
