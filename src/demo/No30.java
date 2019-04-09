package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class No30 {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || k ==0 || k > input.length)
            return res;
        Arrays.sort(input);
        for(int i=0; i<k; i++)
            res.add(input[i]);
        return res;
    }
    
    //利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || k ==0 || k > input.length)
            return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() { 
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });
        for(int i=0; i<input.length; i++){
            if(maxHeap.size() != k)
                maxHeap.offer(input[i]);
            else{
                if(maxHeap.peek() > input[i]){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        for(Integer i: maxHeap){
            res.add(i);
        }
        return res;
    }
}
