package demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָoffer������7�����Ŀ������������ʵ��һ��ջ
 * ����˼·������ջ���������Ͷ��е������ȳ����ص�
 * ��push��ʱ�򣬰�Ԫ����ǿյĶ��������
 * ��pop��ʱ�򣬰Ѳ�Ϊ�յĶ����е�size()-1��Ԫ��poll��������ӵ���Ϊһ��Ϊ�յĶ����У��ٰѶ���������Ԫ��poll����
 * ����������ջ��Ϊ�յ������ʼ������һ��Ϊ�գ���һ����Ϊ�յġ�push���Ԫ�ص��ǿյĶ����У�pop�ѷǿն��е�Ԫ��ת�Ƶ���һ���յĶ����У�
 * ֱ��ʣ�����һ��Ԫ�أ����Ԫ�ؾ���Ҫ��ջ��Ԫ�أ������ӵ������е�Ԫ�أ���
 * @author GL
 *
 */
public class No7fujia {

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        pop();
        push(4);
        pop();
        pop();
        pop();
        pop();

    }

    private static Queue<Object> queue1=new LinkedList<Object>();
    private static Queue<Object> queue2=new LinkedList<Object>();
    
    /*
     * �������ִ����ջ����ʱ����Ԫ����ӵ��ǿյĶ�����
     */
    public static void push(Object item){
        if(!queue1.isEmpty())
            queue1.offer(item);
        else
            queue2.offer(item);
        System.out.println("��ջԪ��Ϊ��"+item);
    }
    
    public static void pop(){
        if(!isEmpty()){
            if(queue1.isEmpty()){
                while(queue2.size()>1){
                    queue1.offer(queue2.poll());
                }
                System.out.println("��ջԪ��Ϊ��"+queue2.poll());
            }else{
                while(queue1.size()>1){
                    queue2.offer(queue1.poll());
                }
                System.out.println("��ջԪ��Ϊ��"+queue1.poll());
            }
        }
        else
            throw new RuntimeException("ջΪ�գ��޷�ִ�г�ջ����");
    }
    
    /*
     * ���ջ�Ƿ�Ϊ��
     */
    private static boolean isEmpty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}