package demo;
import java.util.ArrayList;

public class NO5 {

	public static void main(String[] args) {

	}
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null)
            return new ArrayList<Integer>();
        ListNode head = listNode;
        ListNode cur = listNode.next;
        while( cur!= null){
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        //��ʱlistNode��next��ָ��ڶ���node������Ҫ��listNode.next=null,��ֹѭ��
        listNode.next = null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(head !=null){
            res.add(head.val);
            head = head.next;
        }
        return res;
	}
}

