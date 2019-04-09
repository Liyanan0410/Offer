package demo;

import java.util.Stack;

public class No25 {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value, BinaryTreeNode left,
                BinaryTreeNode right) {
            super();
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node5 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, node5);
        BinaryTreeNode node7 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node3, node4);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node7, null);
        BinaryTreeNode root1 = new BinaryTreeNode(1, node2, node6);
        System.out.println("��·���в�ѯֵΪ9��·����");
        findPath(root1, 9);
        System.out.println("��·���в�ѯֵΪ15��·����");
        findPath(root1, 15);

    }

    private static void findPath(BinaryTreeNode node, int expectedSum) {
        if (node == null)
            return;
        // ����·��
        Stack<Integer> stack = new Stack<Integer>();
        // ��¼��ǰ·���Ͻڵ�ĺ�
        int currentSum = 0;
        findPath(node, stack, expectedSum, currentSum);

    }

    public static void findPath(BinaryTreeNode node, Stack<Integer> stack,
            int expectedSum, int currentSum) {
        if (node == null)
            return;
        currentSum += node.value;
        stack.push(node.value);
        // ��ǰ�ڵ����ΪҶ�ڵ㣬�жϽ��ֵ�ĺ��Ƿ�Ϊ��Ҫ��ѯ��ֵ
        if (node.left == null && node.right == null) {
            if (currentSum == expectedSum) {
                // ջ�Ľṹ������ArrayList�����Ա���ջ���ջ�׵�ջ����˳�����ջ�е�Ԫ��
                for (Integer trace : stack) {
                    System.out.print(trace + ",");
                }
                System.out.println();
            }
        }
        if (node.left != null) {
            findPath(node.left, stack, expectedSum, currentSum);
        }
        if (node.right != null) {
            findPath(node.right, stack, expectedSum, currentSum);
        }
        // ��ǰ�ڵ���ʽ�����ݹ麯���᷵�����ĸ���㣬�����ں����˳�֮ǰ��·����ɾ����ǰ�ڵ㣬����ȥ��ǰ����ֵ
        // ���ڲ��������д����˵�ǰ�����������ֵ�������ں����˳���ǰջ֡��currentSum��ָ���ԭ����ֵ
        stack.pop();
    }

}