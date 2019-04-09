package demo;

/**
 * ��ָoffer������12����ӡ1�����nλ��
 * ��Ŀ����������n����˳���ӡ��1������nλʮ��������
 * ���磺����3�����ӡ1,2,3һֱ��999
 * �ⷨһ��ʹ�������ʾ����
 * @author GL
 *
 */
public class No12 {

    //ʹ������ʵ�ֶ�������+1����
    public static boolean increment(int[] number){
        if(number.length<1)
            throw new RuntimeException("invalid lenth of array");
        //���λ������λ��־���������е���Ϊ����nλ����
        boolean isOverFlow=false;
        //��λλ
        int carry=0;
        //û�в�����λ��+1��ѭ��ֻ����1�Σ�����һ����λ��ѭ��������һ��
        for(int i=number.length-1;i>=0;i--){
            int sum=number[i]+carry;
            if(i==number.length-1)
                sum++;//���λ+1
            if(sum>=10){
                //���λ������λ
                if(i==0)
                    isOverFlow=true;
                //��ͨλ������λ
                else{
                    carry=1;
                    number[i]=0;
                    sum=0;
                }
            }else{
                //��ͨλ+1�Ľ�����浽�����У�+1������˳�ѭ��
                number[i]=sum;
                break;
            }
        }
        return isOverFlow;
    }
    //��ӡ�����б�ʾ��������������б�ʾ������λ��С��n���򲻴�ӡǰ���0
    public static void print(int[] number){
        boolean isBeginning=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning&&number[i]!=0)
                isBeginning=false;
            if(!isBeginning)
                System.out.print(number[i]);
        }
    }
    public static void main(String[] args) {
        int[] number=new int[3];
        while(!increment(number)){
            print(number);
            System.out.println();
        }
    }
}