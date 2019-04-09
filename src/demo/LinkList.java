package demo;

import java.util.Stack;

public class LinkList {
    public ListNode head;
    public ListNode current;
    
    public int size;

    //���������������������
    public void add(int data) {
        //�ж�����Ϊ�յ�ʱ��
        if (head == null) {//���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
            head = new ListNode(data);
            current = head;
        } else {
            //�����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
            current.next = new ListNode(data);
            //������ĵ�ǰ��������ƶ�һλ
            current = current.next;   //�˲��������֮��current���ָ������ӵ��Ǹ����
        }
    }
    
  //�������أ�����������ӽ��
    public void add(ListNode node) {
        if (node == null) {
            return;
        }

        if (head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    //����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
    public void print(ListNode node) {
        if (node == null) {
            return;
        }

        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
    
  //��������ȡ������ĳ���
    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
    
    public int findLastNode(int index) {  //index������ǵ�����index���Ǹ����

        //��һ�α������õ�����ĳ���size
        if (head == null) {
            return -1;
        }

        current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        //�ڶ��α��������������index����������
        current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public ListNode findLastNode(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        //��second�������Ųk-1��λ��
        for (int i = 0; i < k - 1; i++) {
            System.out.println("i��ֵ��" + i);
            second = second.next;
            if (second == null) { //˵��k��ֵ�Ѿ���������ĳ�����
                //throw new NullPointerException("����ĳ���С��" + k); //�����Լ��׳��쳣�����û�����ʾ
                return null;
            }
        }

        //��first��second�����������ƶ���ֱ��second�ߵ����һ�����
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        //��second����ߵ����һ���ڵ��ʱ�򣬴�ʱfirstָ��Ľ���������Ҫ�ҵĽ��
        return first;
    }
    
  //����������������м���
    public ListNode findMidNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        //ÿ���ƶ�ʱ����second����ƶ���λ��first����ƶ�һλ
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        
        //ֱ��second����ƶ���nullʱ����ʱfirstָ��ָ���λ�þ����м����λ��
        return first;
    }
    
  //������������������������ͷ���
    public ListNode mergeLinkList(ListNode head1, ListNode head2) {

        if (head1 == null && head2 == null) {  //�����������Ϊ��
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode head; //�������ͷ���
        ListNode current;  //current���ָ��������

        // һ��ʼ��������current���ָ��head1��head2�н�С�����ݣ��õ�head���
        if (head1.val < head2.val) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;  //�������У�currentָ�����һ������Ӧ��С���Ǹ�����
                current = current.next; //currentָ������
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //�ϲ�ʣ���Ԫ��
        if (head1 != null) { //˵������2�������ˣ��ǿյ�
            current.next = head1;
        }

        if (head2 != null) { //˵������1�������ˣ��ǿյ�
            current.next = head2;
        }

        return head;
    }
    
  //����������ķ�ת
    public ListNode reverseList(ListNode head) {

        //�������Ϊ�ջ���ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���ԭ�����ͷ���
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = null; //���嵱ǰ������һ�����
        ListNode reverseHead = null;  //��ת��������ı�ͷ

        while (current != null) {
            next = current.next;  //��ʱ����ס��ǰ������һ����㣬��Ϊ��һ��Ҫ��

            current.next = reverseHead; //��current����һ�����ָ���������ͷ���
            reverseHead = current;  

            current = next;   // ����������current�ڵ����
        }

        return reverseHead;
    }
    
  //��������β��ͷ��ӡ������
    public void reversePrint(ListNode head) {

        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();  //�½�һ��ջ
        ListNode current = head;

        //����������н��ѹջ
        while (current != null) {
            stack.push(current);  //����ǰ���ѹջ
            current = current.next;
        }

        //��ջ�еĽ���ӡ�������
        while (stack.size() > 0) {
            System.out.println(stack.pop().val);  //��ջ����
        }
    }
    
    public void reversePrint_Recursiveely(ListNode head) {


        if (head == null) {
            return;
        }
        reversePrint_Recursiveely(head.next);
        System.out.println(head.val);
    }
    
  //�������жϵ������Ƿ��л�
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null) {
            first = first.next;   //firstָ����һ��
            second = second.next.next;  //secondָ��������

            if (first == second) {  //һ������ָ��������˵���������л���
                return true;
            }
        }

        return false;
    }
    
  //�������жϵ������Ƿ��л������صĽ�����������Ǹ����
    public ListNode hasCycleForCount(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null) {
            first = first.next;
            second = second.next.next;

            if (first == second) {  //һ������ָ��������˵���������л���
                return first;  //���������Ǹ������з���
            }
        }

        return null;
    }

    //�������л������У���ȡ���ĳ��ȡ�����node��������������Ǹ����
    public int getCycleLength(ListNode node) {

        if (head == null) {
            return 0;
        }

        ListNode current = node;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
            if (current == node) {  //��current����ߵ�ԭ���ʱ��
                return length;
            }
        }

        return length;
    }
    
  //��������ȡ������ʼ�㡣����length��ʾ���ĳ���
    public ListNode getCycleStart(ListNode head, int cycleLength) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        //����secondָ����length��
        for (int i = 0; i < cycleLength; i++) {
            second = second.next;
        }

        //Ȼ����firstָ���secondָ��ͬʱ����һ��
        while (first != null && second != null) {
            first = first.next;
            second = second.next;

            if (first == second) { //�������ָ�������ˣ�˵����������ǻ�����ʼ��
                return first;
            }
        }

        return null;
    }
    
  //�������������������ཻ�ĵ�һ������
    public ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head == null) {
            return null;
        }

        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int lengthDif = 0;  //���������ȵĲ�ֵ

        ListNode longHead;
        ListNode shortHead;

        //�ҳ��ϳ����Ǹ�����
        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
            lengthDif = length1 - length2;
        } else {
            longHead = head2;
            shortHead = head1;
            lengthDif = length2 - length1;
        }

        //���ϳ����Ǹ������ָ����ǰ��length������
        for (int i = 0; i < lengthDif; i++) {
            longHead = longHead.next;
        }

        //�����������ָ��ͬʱ��ǰ�ƶ�
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) { //��һ����ͬ�Ľ������ཻ�ĵ�һ�����
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return null;
    }
//    class Node {
//        //ע���˴���������Ա����Ȩ�޲���Ϊprivate����Ϊprivate��Ȩ���ǽ��Ա�����ʡ�
//        int data; //������
//        Node next;//ָ����
//
//        public Node(int data) {
//            this.data = data;
//        }
//    }
//    public static void main(String[] args) {
//        LinkList list = new LinkList();
//        //��LinkList���������
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        list.print(list.head);// ��head�ڵ㿪ʼ�������
//    }
//    public static void main(String[] args) {
//        LinkList list = new LinkList();
//        //��LinkList���������
//        for (int i = 0; i < 4; i++) {
//            list.add(i);
//        }
//
//        list.add(list.head);  //��ͷ�����ӵ������У����ǣ���������л��ˡ���ע����ʱ�õ���������Ľṹ��������ĵ�8С����ͼ1�����ֽṹ��
//
//        System.out.println(list.hasCycle(list.head));
//    }
//    public static void main(String[] args) {
//        LinkList list1 = new LinkList();
//
//        Node second = null; //�ѵڶ�����������
//
//        //��LinkList���������
//        for (int i = 0; i < 4; i++) {
//            list1.add(i);
//
//            if (i == 1) {
//                second = list1.current;  //�ѵڶ�����������
//            }
//        }
//
//        list1.add(second);   //��β���ָ������ĵڶ�����㣬���ǵ�������л��ˣ���ע����ʱ�õ��Ļ��Ľṹ���Ǳ�����ͼ2�����ֽṹ
//        Node current = list1.hasCycle(list1.head);  //��ȡ�������Ǹ����
//
//        System.out.println("���ĳ���Ϊ" + list1.getCycleLength(current));
//    }
//    public static void main(String[] args) {
//        LinkList list1 = new LinkList();
//
//        Node second = null; //�ѵڶ�����������
//
//        //��LinkList���������
//        for (int i = 0; i < 4; i++) {
//            list1.add(i);
//
//            if (i == 1) {
//                second = list1.current;  //�ѵڶ�����������
//            }
//        }
//
//        list1.add(second);   //��β���ָ������ĵڶ�����㣬���ǵ�������л��ˣ���ע����ʱ�õ��Ļ��Ľṹ���Ǳ�����ͼ2�����ֽṹ
//        Node current = list1.hasCycle(list1.head);  //��ȡ�������Ǹ����
//
//        int length = list1.getCycleLength(current); //��ȡ���ĳ���
//
//        System.out.println("������ʼ����" + list1.getCycleStart(list1.head, length).data);
//
//    }

}
