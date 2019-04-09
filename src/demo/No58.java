package demo;

//�����������
//
//�����ǰ�ڵ�Ϊ�գ�ֱ�ӷ��ؿգ�
//�����ǰ�ڵ������������򷵻�������������������
//�����ǰ�ڵ�û�����������ٷ����������
//������ǰ�ڵ��ǲ������ĸ��ڵ��������������ǣ��򷵻����ĸ��ڵ㣻
//�����ǰ�ڵ㲻�����ĸ��ڵ������������Ѹ��ڵ㸳����ǰ�ڵ㣬���жϵ�ǰ�ڵ��ǲ������ĸ��ڵ����������
//ֱ����ǰ�ڵ��ǲ������ĸ��ڵ�����������������ĸ��ڵ㡣
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
