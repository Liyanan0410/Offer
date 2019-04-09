package demo;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class No60 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null)
            return res;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        layer.offer(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode node = layer.poll();
            temp.add(node.val);
            start ++;
            if(node.left != null)
                layer.add(node.left);
            if(node.right != null)
                layer.add(node.right);
            if(start == end){
                start = 0;
                res.add(temp);
                temp = new ArrayList<Integer>();
                end = layer.size();
            }
        }
        return res;
	}
}
