package tx;

import java.util.Comparator;
import java.util.PriorityQueue;

public class sortList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode head = fun(node1);
        while(head != null) {
        	System.out.println(head.val);
        	head = head.next;
        }

	}
	public static ListNode fun(ListNode head) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
		    public int compare(Integer i1,Integer i2){
		        return i2-i1;
		    }
		});
		if(head == null) {
			return null;
		}
		while(head != null){
			maxHeap.add(head.val);
			head = head.next;
		}
		
		while(maxHeap.size() != 0) {
			ListNode temphead = new ListNode(maxHeap.poll());
			temphead.next = head;
			head = temphead;
		}
        return head;
    }
	

//	 Definition for singly-linked list.
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
}
