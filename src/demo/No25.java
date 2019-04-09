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
        System.out.println("在路径中查询值为9的路径：");
        findPath(root1, 9);
        System.out.println("在路径中查询值为15的路径：");
        findPath(root1, 15);

    }

    private static void findPath(BinaryTreeNode node, int expectedSum) {
        if (node == null)
            return;
        // 保存路径
        Stack<Integer> stack = new Stack<Integer>();
        // 记录当前路径上节点的和
        int currentSum = 0;
        findPath(node, stack, expectedSum, currentSum);

    }

    public static void findPath(BinaryTreeNode node, Stack<Integer> stack,
            int expectedSum, int currentSum) {
        if (node == null)
            return;
        currentSum += node.value;
        stack.push(node.value);
        // 当前节点如果为叶节点，判断结点值的和是否为所要查询的值
        if (node.left == null && node.right == null) {
            if (currentSum == expectedSum) {
                // 栈的结构类似于ArrayList，所以遍历栈会从栈底到栈顶的顺序访问栈中的元素
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
        // 当前节点访问结束后递归函数会返回它的父结点，所以在函数退出之前在路径上删除当前节点，并减去当前结点的值
        // 由于参数传递中传递了当前结点参与运算的值，所以在函数退出当前栈帧后，currentSum会恢复成原来的值
        stack.pop();
    }

}