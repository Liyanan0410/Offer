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
    
    //把复杂链表中的所有结点进行复制，并连接在原结点的后面
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
    //设置复制的节点的指向任意结点的连接关系
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
    //把长链表拆分成两个单独的链表，并返回复制后的链表的头结点
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
            StringBuilder sb=new StringBuilder("当前节点的值为：").append(value);
            if(next!=null)
                sb.append(",下一结点的值为：").append(next.value);
            else
                sb.append(",当前结点为尾节点");
            if(sibling!=null)
                sb.append(",指向任意结点的值为：").append(sibling.value);
            else
                sb.append(",没有指向其他结点的任意结点");
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
        System.out.println("=========================开始复制============================");
        printComplexList(copyComplexList(node1));
    }
}