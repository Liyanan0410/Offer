package demo;


public class No16 {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int value, ListNode next) {
            this.data = value;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            throw new RuntimeException("invalid List,can't be null");
        if (head.next == null)
            return head;
        ListNode reversedHead = null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null)
                reversedHead = node;
            // 赋值顺序不能变
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return reversedHead;
    }

    public static void print(ListNode head) {
        if (head == null)
            System.out.println("当前链表为空");
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);

        print(reverseList(node4));
        System.out.println();
        print(reverseList(new ListNode(5, null)));
        System.out.println();
        print(reverseList(new ListNode()));
        System.out.println();
    }

}