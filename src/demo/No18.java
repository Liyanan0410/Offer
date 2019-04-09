package demo;
/**
 * ������ 18�������ӽṹ
 * ��Ŀ���������Ŷ����� A �� B���ж� B �ǲ��� A ���ӽṹ��
 * 
 * @author Stephen Huge
 * @date 17/04/25
 */
public class No18 {
    public static void main(String[] args) {
        No18 jst = new No18();
        BinaryNode a = new BinaryNode(2);
        BinaryNode b = new BinaryNode(2);
        BinaryNode c = new BinaryNode(3);
        BinaryNode d = new BinaryNode(4);
        BinaryNode e = new BinaryNode(5);
        BinaryNode f = new BinaryNode(6);
        a.lChild = b;
        a.rChild = c;
        b.lChild = d;
        b.rChild = e;
        c.lChild = f;
        boolean sol = jst.judgeSubTree(a, b);
//      boolean sol = jst.judgeSubTree(a, a);
//      boolean sol = jst.judgeSubTree(a, jst.new BinaryNode(7));
        System.out.println(sol);
    }

    public boolean judgeSubTree(BinaryNode biNode, BinaryNode sub) {
        if(sub == null) {
            return true;
        }else if(biNode == null) {
            return false;
        }
        if(biNode.data == sub.data) {   
//          return judgeSubTree(biNode.lChild, sub.lChild) && 
//                  judgeSubTree(biNode.rChild, sub.rChild);//����Ҫע�⣺������ֵ����ȣ�ֱ�ӷ��ػᵼ���жϴ���
            if(judgeSubTree(biNode.lChild, sub.lChild) && 
                    judgeSubTree(biNode.rChild, sub.rChild) == true) {
                return true;
            }
        }
        boolean result = false; 
        result = judgeSubTree(biNode.lChild, sub);
        if(!result) {
            result = judgeSubTree(biNode.rChild, sub);  
        }
        return result;
    }
  public static class BinaryNode{//���鱣�����µ��ļ��У���Ȼ��main�����½�ʱ�ķ�ʽ��BinaryNode node = jsp.new BinaryNode(1);
      int data;
      BinaryNode lChild;
      BinaryNode rChild;
      public BinaryNode(int data) {
          this.data = data;
      }
  }
}