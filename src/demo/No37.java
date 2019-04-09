package demo;
import java.util.Stack;

public class No37 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(pHead1 != null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode res = null;
        while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()){
            s1.pop();
            res = s2.pop();
        }
        return res;
    }
	
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int count1 = 1, count2 = 1;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1.next != null){
            p1 = p1.next;
            count1++;
        }
        while(p2.next != null){
            p2 = p2.next;
            count2++;
        }
        if(count1>count2){
            int dif = count1 - count2;
            while(dif != 0){
                pHead1 = pHead1.next;
                dif--;
            }
        }else{
            int dif = count2 - count1;
            while(dif != 0){
                pHead2 = pHead2.next;
                dif--;
            }
        }
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
