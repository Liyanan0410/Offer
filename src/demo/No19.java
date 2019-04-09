package demo;

import java.util.Stack;

public class No19 {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public class Solution {
	    public void Mirror(TreeNode root) {
	        //��ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
	        if(root == null)
	            return;
	        //��ǰ�ڵ�û��Ҷ�ӽڵ㣬ֱ�ӷ���
	        if(root.left == null && root.right == null)
	            return;
	        TreeNode temp = root.left;
	        root.left = root.right;
	        root.right = temp;
	        //�ݹ齻��Ҷ�ӽڵ�
	        if(root.left != null)
	            Mirror(root.left);
	        if(root.right != null)
	            Mirror(root.right);
	    }
	}
	
	public static void SetMirrorIteratively(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty())
        {
        	TreeNode node = stack.pop();

        	TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
            {
                stack.push(node.left);
            }

            if (node.right != null)
            {
                stack.push(node.right);
            }
        }
    }
}
