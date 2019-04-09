package demo;

/**
 * 剑指offer面试题12：打印1到最大n位数
 * 题目：输入数字n，按顺序打印从1到最大的n位十进制数。
 * 比如：输入3，则打印1,2,3一直到999
 * 解法一：使用数组表示大数
 * @author GL
 *
 */
public class No12 {

    //使用数组实现对数进行+1操作
    public static boolean increment(int[] number){
        if(number.length<1)
            throw new RuntimeException("invalid lenth of array");
        //最高位产生进位标志，则数组中的数为最大的n位整数
        boolean isOverFlow=false;
        //进位位
        int carry=0;
        //没有产生进位的+1，循环只运行1次，产生一个进位，循环多运行一次
        for(int i=number.length-1;i>=0;i--){
            int sum=number[i]+carry;
            if(i==number.length-1)
                sum++;//最低位+1
            if(sum>=10){
                //最高位产生进位
                if(i==0)
                    isOverFlow=true;
                //普通位产生进位
                else{
                    carry=1;
                    number[i]=0;
                    sum=0;
                }
            }else{
                //普通位+1的结果保存到数组中，+1后程序退出循环
                number[i]=sum;
                break;
            }
        }
        return isOverFlow;
    }
    //打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
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