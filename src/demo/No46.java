package demo;

public class No46 {
//	�ۼӲ�����ѭ���Ļ����Ǿ����Եݹ�ɡ�
//	�жϵݹ����ֹ���������� if �� switch���Ǿ��ö�·����档
//	(n > 0) && (sum += Sum_Solution(n-1))>0
//	ֻ������n > 0��������&&����ı��ʽ�Ż�ִ�С�
	public int Sum_Solution(int n) {
        int sum = n;
        boolean t = (n > 0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
