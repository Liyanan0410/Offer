package demo;

public class No15 {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.data = value;
            this.next = next;
        }
    }

    public static ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (head == null)
            throw new RuntimeException("待查找的链表不能为空");
        if (k <= 0)
            throw new RuntimeException("输入的位置数字不合法");
        ListNode ahead = head;
        ListNode behind = head;
        // 第一个指针先指向K-1，并检验链表中节点个数是否大于k
        int count = 1;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
                count++;
            } else
                throw new RuntimeException("链表节点个数：" + count + " 小于输入K的个数：" + k);
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node3);
        ListNode find = findKthNodeFromEnd(head, 3);
        System.out.println("找到的节点位" + find.data);
        ListNode find2 = findKthNodeFromEnd(head, 5);
        System.out.println("找到的节点位" + find2.data);
    }
}