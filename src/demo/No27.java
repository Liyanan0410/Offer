package demo;

public class No27 {

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode() {

        }

        public BinaryTreeNode(int value, BinaryTreeNode left,
                BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeInList = null;
        lastNodeInList = convertToNode(root, lastNodeInList);
        BinaryTreeNode head = lastNodeInList;
        // ��β�ڵ㷵��ͷ���
        while (head != null && head.left != null) {
            head = head.left;
        }
        printList(head);
        return head;
    }

    private static BinaryTreeNode convertToNode(BinaryTreeNode node,
            BinaryTreeNode lastNodeInList) {
        if (node == null)
            return null;
        BinaryTreeNode current = node;
        // �ݹ�Ĵ���������
        if (current.left != null)
            lastNodeInList = convertToNode(current.left, lastNodeInList);
        // ʹ�����е����һ�����ָ������������С�Ľڵ�
        current.left = lastNodeInList;
        // �����е����һ�����ָ��ǰ�ڵ㣬��ǰ�ڵ�ͳ��������е����һ�����
        if (lastNodeInList != null)
            lastNodeInList.right = current;
        lastNodeInList = current;
        // �ݹ�ת��������
        if (current.right != null)
            lastNodeInList = convertToNode(current.right, lastNodeInList);

        return lastNodeInList;
    }

    public static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + ",");
            head = head.right;
        }
    }

    // �������������
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + ",");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();
        node7.value = 16;
        node6.value = 12;
        node5.value = 14;
        node5.left = node6;
        node5.right = node7;
        node3.value = 4;
        node4.value = 8;
        node2.value = 6;
        node2.left = node3;
        node2.right = node4;
        node1.value = 10;
        node1.left = node2;
        node1.right = node5;
        printTree(node1);
        System.out.println();
        System.out.println("=============��ӡ����================");
        convert(node1);
    }
}