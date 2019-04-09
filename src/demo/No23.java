package demo;

import java.util.LinkedList;
import java.util.Queue;

public class No23 {

    static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public  BinaryTreeNode(int value,BinaryTreeNode left,BinaryTreeNode right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    public static void printBinaryTreeFromTopToBottom(BinaryTreeNode node){
        if(node==null)
            throw new RuntimeException("invalid parameter");
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            BinaryTreeNode currentNode=queue.poll();
            System.out.print(currentNode.value +",");
            if(currentNode.left!=null)
                queue.add(currentNode.left);
            if(currentNode.right!=null)
                queue.add(currentNode.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1=new BinaryTreeNode(5,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node3=new BinaryTreeNode(9,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(11,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(6,node1,node2);
        BinaryTreeNode node6=new BinaryTreeNode(10,node3,node4);
        BinaryTreeNode node7=new BinaryTreeNode(8,node5,node6);
        printBinaryTreeFromTopToBottom(node7);
    }
}