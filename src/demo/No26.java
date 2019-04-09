package demo;

public class No26 {

    static class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
        public ComplexListNode(){
            
        }
        public ComplexListNode(int value,ComplexListNode next,ComplexListNode sibling){
            this.value=value;
            this.next=next;
            this.sibling=sibling;
        }
    }
    
    //�Ѹ��������е����н����и��ƣ���������ԭ���ĺ���
    private static void cloneNode(ComplexListNode head){
        ComplexListNode node=head;
        while(node!=null){
            ComplexListNode clonedNode=new ComplexListNode();
            clonedNode.value=node.value;
            clonedNode.next=node.next;
            clonedNode.sibling=null;
            node.next=clonedNode;
            node=clonedNode.next;
        }
    }
    //���ø��ƵĽڵ��ָ������������ӹ�ϵ
    private static void connectSiblingNodes(ComplexListNode head){
        ComplexListNode node=head;
        while(node!=null){
            ComplexListNode clonedNode=node.next;
            if(node.sibling!=null){
                clonedNode.sibling=node.sibling.next;
            }
            node=clonedNode.next;
        }
    }
    //�ѳ������ֳ��������������������ظ��ƺ�������ͷ���
    private static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode node=head;
        ComplexListNode clonedHead=null;
        ComplexListNode clonedNode=null;
        if(node!=null){
            clonedHead=clonedNode=node.next;
            node.next=clonedNode.next;
            node=clonedNode.next;
        }
        while(node!=null){
            clonedNode.next=node.next;
            clonedNode=node.next;
            node.next=clonedNode.next;
            node=clonedNode.next;
        }
        return clonedHead;
    }
    public static ComplexListNode copyComplexList(ComplexListNode head){
        if(head==null)
            return null;
        cloneNode(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }
    
    public static void printComplexList(ComplexListNode head){
        ComplexListNode node=head;
        int  value=0;
        ComplexListNode next=null;
        ComplexListNode sibling=null;
        while(node!=null){
            value=node.value;
            next=node.next;
            sibling=node.sibling;
            StringBuilder sb=new StringBuilder("��ǰ�ڵ��ֵΪ��").append(value);
            if(next!=null)
                sb.append(",��һ����ֵΪ��").append(next.value);
            else
                sb.append(",��ǰ���Ϊβ�ڵ�");
            if(sibling!=null)
                sb.append(",ָ���������ֵΪ��").append(sibling.value);
            else
                sb.append(",û��ָ����������������");
            System.out.println(sb.toString());    
            node=node.next;
        }
    }
    public static void main(String[] args) {
        ComplexListNode node1=new ComplexListNode();
        ComplexListNode node2=new ComplexListNode();
        ComplexListNode node3=new ComplexListNode();
        ComplexListNode node4=new ComplexListNode();
        ComplexListNode node5=new ComplexListNode();
        node1.value=1;
        node1.next=node2;
        node1.sibling=node3;
        node2.value=2;
        node2.next=node3;
        node2.sibling=node5;
        node3.value=3;
        node3.next=node4;
        node3.sibling=null;
        node4.value=4;
        node4.next=node5;
        node4.sibling=node2;
        node5.value=5;
        node5.next=null;
        node5.sibling=null;
        printComplexList(node1);
        System.out.println("=========================��ʼ����============================");
        printComplexList(copyComplexList(node1));
    }
}