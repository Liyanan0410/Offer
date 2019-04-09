package demo;

public class No63 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if(node != null)
                return node;
        }
        return null;
    }
}
