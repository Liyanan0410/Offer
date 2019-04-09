package demo;

import java.util.Stack;

public class LinkList {
    public ListNode head;
    public ListNode current;
    
    public int size;

    //方法：向链表中添加数据
    public void add(int data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new ListNode(data);
            current = head;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new ListNode(data);
            //把链表的当前索引向后移动一位
            current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
        }
    }
    
  //方法重载：向链表中添加结点
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

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
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
    
  //方法：获取单链表的长度
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
    
    public int findLastNode(int index) {  //index代表的是倒数第index的那个结点

        //第一次遍历，得到链表的长度size
        if (head == null) {
            return -1;
        }

        current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        //第二次遍历，输出倒数第index个结点的数据
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

        //让second结点往后挪k-1个位置
        for (int i = 0; i < k - 1; i++) {
            System.out.println("i的值是" + i);
            second = second.next;
            if (second == null) { //说明k的值已经大于链表的长度了
                //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
                return null;
            }
        }

        //让first和second结点整体向后移动，直到second走到最后一个结点
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        //当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
        return first;
    }
    
  //方法：查找链表的中间结点
    public ListNode findMidNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        //每次移动时，让second结点移动两位，first结点移动一位
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        
        //直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
        return first;
    }
    
  //两个参数代表的是两个链表的头结点
    public ListNode mergeLinkList(ListNode head1, ListNode head2) {

        if (head1 == null && head2 == null) {  //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode head; //新链表的头结点
        ListNode current;  //current结点指向新链表

        // 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
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
                current.next = head1;  //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }

        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }

        return head;
    }
    
  //方法：链表的反转
    public ListNode reverseList(ListNode head) {

        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = null; //定义当前结点的下一个结点
        ListNode reverseHead = null;  //反转后新链表的表头

        while (current != null) {
            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;  

            current = next;   // 操作结束后，current节点后移
        }

        return reverseHead;
    }
    
  //方法：从尾到头打印单链表
    public void reversePrint(ListNode head) {

        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();  //新建一个栈
        ListNode current = head;

        //将链表的所有结点压栈
        while (current != null) {
            stack.push(current);  //将当前结点压栈
            current = current.next;
        }

        //将栈中的结点打印输出即可
        while (stack.size() > 0) {
            System.out.println(stack.pop().val);  //出栈操作
        }
    }
    
    public void reversePrint_Recursiveely(ListNode head) {


        if (head == null) {
            return;
        }
        reversePrint_Recursiveely(head.next);
        System.out.println(head.val);
    }
    
  //方法：判断单链表是否有环
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null) {
            first = first.next;   //first指针走一步
            second = second.next.next;  //second指针走两步

            if (first == second) {  //一旦两个指针相遇，说明链表是有环的
                return true;
            }
        }

        return false;
    }
    
  //方法：判断单链表是否有环。返回的结点是相遇的那个结点
    public ListNode hasCycleForCount(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null) {
            first = first.next;
            second = second.next.next;

            if (first == second) {  //一旦两个指针相遇，说明链表是有环的
                return first;  //将相遇的那个结点进行返回
            }
        }

        return null;
    }

    //方法：有环链表中，获取环的长度。参数node代表的是相遇的那个结点
    public int getCycleLength(ListNode node) {

        if (head == null) {
            return 0;
        }

        ListNode current = node;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
            if (current == node) {  //当current结点走到原点的时候
                return length;
            }
        }

        return length;
    }
    
  //方法：获取环的起始点。参数length表示环的长度
    public ListNode getCycleStart(ListNode head, int cycleLength) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        //先让second指针走length步
        for (int i = 0; i < cycleLength; i++) {
            second = second.next;
        }

        //然后让first指针和second指针同时各走一步
        while (first != null && second != null) {
            first = first.next;
            second = second.next;

            if (first == second) { //如果两个指针相遇了，说明这个结点就是环的起始点
                return first;
            }
        }

        return null;
    }
    
  //方法：求两个单链表相交的第一个交点
    public ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head == null) {
            return null;
        }

        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int lengthDif = 0;  //两个链表长度的差值

        ListNode longHead;
        ListNode shortHead;

        //找出较长的那个链表
        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
            lengthDif = length1 - length2;
        } else {
            longHead = head2;
            shortHead = head1;
            lengthDif = length2 - length1;
        }

        //将较长的那个链表的指针向前走length个距离
        for (int i = 0; i < lengthDif; i++) {
            longHead = longHead.next;
        }

        //将两个链表的指针同时向前移动
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) { //第一个相同的结点就是相交的第一个结点
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return null;
    }
//    class Node {
//        //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
//        int data; //数据域
//        Node next;//指针域
//
//        public Node(int data) {
//            this.data = data;
//        }
//    }
//    public static void main(String[] args) {
//        LinkList list = new LinkList();
//        //向LinkList中添加数据
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        list.print(list.head);// 从head节点开始遍历输出
//    }
//    public static void main(String[] args) {
//        LinkList list = new LinkList();
//        //向LinkList中添加数据
//        for (int i = 0; i < 4; i++) {
//            list.add(i);
//        }
//
//        list.add(list.head);  //将头结点添加到链表当中，于是，单链表就有环了。备注：此时得到的这个环的结构，是下面的第8小节中图1的那种结构。
//
//        System.out.println(list.hasCycle(list.head));
//    }
//    public static void main(String[] args) {
//        LinkList list1 = new LinkList();
//
//        Node second = null; //把第二个结点记下来
//
//        //向LinkList中添加数据
//        for (int i = 0; i < 4; i++) {
//            list1.add(i);
//
//            if (i == 1) {
//                second = list1.current;  //把第二个结点记下来
//            }
//        }
//
//        list1.add(second);   //将尾结点指向链表的第二个结点，于是单链表就有环了，备注：此时得到的环的结构，是本节中图2的那种结构
//        Node current = list1.hasCycle(list1.head);  //获取相遇的那个结点
//
//        System.out.println("环的长度为" + list1.getCycleLength(current));
//    }
//    public static void main(String[] args) {
//        LinkList list1 = new LinkList();
//
//        Node second = null; //把第二个结点记下来
//
//        //向LinkList中添加数据
//        for (int i = 0; i < 4; i++) {
//            list1.add(i);
//
//            if (i == 1) {
//                second = list1.current;  //把第二个结点记下来
//            }
//        }
//
//        list1.add(second);   //将尾结点指向链表的第二个结点，于是单链表就有环了，备注：此时得到的环的结构，是本节中图2的那种结构
//        Node current = list1.hasCycle(list1.head);  //获取相遇的那个结点
//
//        int length = list1.getCycleLength(current); //获取环的长度
//
//        System.out.println("环的起始点是" + list1.getCycleStart(list1.head, length).data);
//
//    }

}
