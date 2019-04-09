package demo;
import java.util.ArrayList;
import java.util.Stack;

public class No61 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        int flag = 1;
        if(pRoot == null)
            return res;
        s2.push(pRoot);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(flag % 2 != 0){
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if(node.left != null){
                        s1.push(node.left);
                    }
                    if(node.right != null){
                        s1.push(node.right);
                    }
                }
            }
            if(flag % 2 == 0){
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if(node.right != null){
                        s2.push(node.right);
                    }
                    if(node.left != null){
                        s2.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<Integer>(temp));
            temp.clear();
            flag ++;
        }
        return res;
    }
}
