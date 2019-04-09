package demo;

//分三种情况：
//
//如果当前节点为空，直接返回空；
//如果当前节点有右子树，则返回右子树的最左子树；
//如果当前节点没有右子树，再分两种情况：
//看看当前节点是不是它的父节点的左子树，如果是，则返回它的父节点；
//如果当前节点不是它的父节点的左子树，则把父节点赋给当前节点，再判断当前节点是不是它的父节点的左子树，
//直到当前节点是不是它的父节点的左子树，返回它的父节点。
public class No58 {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        while(pNode.next != null){
            TreeLinkNode root = pNode.next;
            if(pNode == root.left)
                return root;
            pNode = root;
        }
        return null;
    }
}
