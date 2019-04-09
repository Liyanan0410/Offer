package demo;
import java.util.LinkedList;

public class No45 {
	public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        LinkedList<Integer> link = new LinkedList<Integer>();
        for(int i = 0; i < n; i++)
            link.add(i);
        int index = -1;   //起步是 -1 不是 0
        while(link.size() > 1){
            index = (index + m) % link.size();  //对 link的长度求余不是对 n
            link.remove(index);
            index --;
        }
        return link.get(0);
    }
}
