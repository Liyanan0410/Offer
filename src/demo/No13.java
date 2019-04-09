package demo;

/**
 * ��ָoffer������13:��O(1)ʱ��ɾ������ڵ�
 * ��Ŀ���������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ㡣
 * @author GL
 *
 */
public class No13 {

    public static class ListNode{
        public int data;
        public ListNode next;
        public ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
    }

    public static ListNode deleteNode(ListNode head,ListNode node){
        //ɾ��β�ڵ㣬����˳������ҵ�β�ڵ��ǰһ�ڵ�
        if(node.next==null){
            while(head.next!=node){
                head=head.next;
            }
            head.next=null;
        }
        //Ҫɾ���Ľڵ���ͷ���
        else if(head==node){
            head=null;
        }
        //Ҫɾ���Ľڵ����м���ͨ�ڵ�
        else{
            node.data=node.next.data;
            node.next=node.next.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode tail=new ListNode(1,null);
        ListNode c=new ListNode(2,tail);
        ListNode b=new ListNode(3,c);
        ListNode head=new ListNode(4,b);
        deleteNode(head,c);
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }

    }
}