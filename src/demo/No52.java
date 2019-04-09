package demo;

//��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
//1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
//2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��
//
//����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
//����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
//1��ģʽ����2�ַ����൱��x*�����ԣ�
//2���ַ�������1�ַ���ģʽ����2�ַ���
//3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
public class No52 {
	public boolean match(char[] str, char[] pattern)
    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        if(sindex >= str.length && pindex == pattern.length)
            return true;
        if(pindex >= pattern.length && sindex < str.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                    matchCore(str, sindex+1, pindex+2, pattern ) ||
                    matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }
}
