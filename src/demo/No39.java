package demo;
import java.util.Queue;
import java.util.LinkedList;

public class No39 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return left > right ? left : right;
    }
	
//	层次遍历。每遍历一层，deep 加 1，直接到最后一层，输出 deep。
	public int TreeDepth2(TreeNode root) {
        if(root == null)
            return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int start = 0, end = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            start ++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(start == end){
                end = queue.size();
                start = 0;
                deep ++;
            }
        }
        return deep;
    }
}
