package demo;

public class No47 {
//	step1: ����������㣬��������������λ���ϵ���ӣ������ǽ�λ��
//	step2: ����λ�����㣬Ȼ������һλ�������λֵ��
//	step3: ���������Ľ������ num1���ѽ�λֵ���� num2������ѭ������λֵΪ�յ�ʱ�����ѭ����num1��
//	������֮��
	public int Add(int num1, int num2) {
        if(num2 == 0)
            return num1;
        int sum = 0, carry = 0;
        while(num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
