package demo;
import java.util.ArrayList;

public class No20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if(row == 0 && col == 0)
            return res;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom){
            //�ϣ�������
            for(int i=left; i<=right; i++)
                res.add(matrix[top][i]);
            //�ң����ϵ���
            for(int i=top+1; i<=bottom; i++)
                res.add(matrix[i][right]);
            //�£����ҵ���
            if(top != bottom){
                //��ֹ�������
                for(int i=right-1; i>=left; i--)
                    res.add(matrix[bottom][i]);
            }
            //�󣺴��µ���
            if(left != right){
                //��ֹ�������
                for(int i=bottom-1; i>top; i--)
                    res.add(matrix[i][left]);
            }
            left++; right--; top++; bottom--;
        }
        return res;
    }
    
    public void printMatrix2(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null){
            return;
        }

        int m = matrix.length;
        int n = 0;
        if(m > 0){
            n = matrix[0].length;
        }else{
            return;
        }

        int start = 0;
        while(n > start * 2 && m > start * 2){
            printMatrixInCircle(matrix, m, n, start, result);
            start++;
        }
    }
    
    public static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> print){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //�����Ҵ�ӡһ��
        for(int i = start; i <= endX; i++){
            int num = matrix[start][i];
            print.add(num);
        }

        //���ϵ��´�ӡһ��
        if(start < endY){
           for(int i = start + 1; i <= endY; i++){
               int num = matrix[i][endX];
               print.add(num);
           } 
        }

        //���ҵ����ӡһ��
        if(start < endX && start < endY){
            for(int i = endX - 1; i >= start; i--){
                int num = matrix[endY][i];
                print.add(num);
            }
        }

        //���µ��ϴ�ӡһ��
        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i >= start+1; i--){
                int num = matrix[i][start];
                print.add(num);
            }
        }
    }
}