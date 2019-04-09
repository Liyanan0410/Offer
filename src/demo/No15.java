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
            throw new RuntimeException("�����ҵ�������Ϊ��");
        if (k <= 0)
            throw new RuntimeException("�����λ�����ֲ��Ϸ�");
        ListNode ahead = head;
        ListNode behind = head;
        // ��һ��ָ����ָ��K-1�������������нڵ�����Ƿ����k
        int count = 1;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
                count++;
            } else
                throw new RuntimeException("����ڵ������" + count + " С������K�ĸ�����" + k);
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
        System.out.println("�ҵ��Ľڵ�λ" + find.data);
        ListNode find2 = findKthNodeFromEnd(head, 5);
        System.out.println("�ҵ��Ľڵ�λ" + find2.data);
    }
}