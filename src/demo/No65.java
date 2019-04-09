package demo;
import java.util.ArrayList;
import java.util.LinkedList;

public class No65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<Integer> deque = new LinkedList<Integer>();
        if(num.length == 0 || size == 0)
            return res;
        for(int i = 0; i < num.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.poll();
            while(!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.removeLast();
            deque.offerLast(i);
            if(i + 1 >= size)
                res.add(num[deque.peekFirst()]);
        }
        return res;
    }
}
