package demo;

public class No34 {
//	����ֻ���������Ҫȥ�ܷǳ�����ÿ��������Ȼ����С������ĳ����������2��3��5�õ��ģ��������ǰ���õĳ�����������
//	������֮ǰ�ĳ����ֱ����2��3��5���ҳ�����������С�Ĳ��Ҵ��ڵ�ǰ��������ֵ����Ϊ��һ������Ҫ��ĳ��������ַ�
//	���ÿռ任ʱ�䣬ʱ�临�Ӷ�ΪO(n)��
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
