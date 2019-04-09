package demo;
import java.util.ArrayList;

public class No41_2 {
//	�������ڵķ��������������� start �� end �ֱ��ʾ���е���Сֵ�����ֵ�����Ƚ� start ��ʼ��Ϊ1��
//	end ��ʼ��Ϊ2�������start��end�ĺʹ���sum�����Ǿʹ�������ȥ����С��ֵ(������start),
//	�෴��ֻ��Ҫ����end��
//	��ֹ����Ϊ��һֱ����begin��(1+sum)/2����endС��sumΪֹ
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
