package demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer面试题7相关题目：用两个队列实现一个栈
 * 解题思路：根据栈的先入后出和队列的先入先出的特点
 * 在push的时候，把元素向非空的队列内添加
 * 在pop的时候，把不为空的队列中的size()-1份元素poll出来，添加到另为一个为空的队列中，再把队列中最后的元素poll出来
 * 两个队列在栈不为空的情况下始终是有一个为空，另一个不为空的。push添加元素到非空的队列中，pop把非空队列的元素转移到另一个空的队列中，
 * 直到剩下最后一个元素，这个元素就是要出栈的元素（最后添加到队列中的元素）。
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
     * 向队列中执行入栈操作时，把元素添加到非空的队列中
     */
    public static void push(Object item){
        if(!queue1.isEmpty())
            queue1.offer(item);
        else
            queue2.offer(item);
        System.out.println("入栈元素为："+item);
    }
    
    public static void pop(){
        if(!isEmpty()){
            if(queue1.isEmpty()){
                while(queue2.size()>1){
                    queue1.offer(queue2.poll());
                }
                System.out.println("出栈元素为："+queue2.poll());
            }else{
                while(queue1.size()>1){
                    queue2.offer(queue1.poll());
                }
                System.out.println("出栈元素为："+queue1.poll());
            }
        }
        else
            throw new RuntimeException("栈为空，无法执行出栈操作");
    }
    
    /*
     * 检查栈是否为空
     */
    private static boolean isEmpty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}