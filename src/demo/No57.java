package demo;

public class No57 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode first = head;
        ListNode second = first.next;
        while(second != null){
            if(second.next != null && second.val == second.next.val){
                while(second.next != null && second.val == second.next.val){
                    second = second.next;
                }
                first.next = second.next;
            }else{
                first = first.next;
            }
            second = second.next;
        }
        return head.next;
    }
}
