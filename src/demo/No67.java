package demo;

public class No67 {
    public int movingCount(int threshold, int rows, int cols)
    {   
        if(threshold == 0)
            return 0;
        int flag[][] = new int[rows][cols];
        return count(threshold, rows, cols, 0, 0, flag);
    }
    public int count(int threshold, int rows, int cols, int i, int j, int[][] flag){
        if(i<0 || j<0 || i>=rows || j>=cols || sum(i)+sum(j) > threshold || flag[i][j] == 1){
            return 0;
        }
        flag[i][j] = 1;
        return 1 + count(threshold, rows, cols, i - 1, j, flag) + 
            count(threshold, rows, cols, i + 1, j, flag) +
            count(threshold, rows, cols, i, j - 1, flag) +
            count(threshold, rows, cols, i, j + 1, flag);
    }
    public int sum(int i){
        int s = 0;
        while(i>0){
            s += i%10;
            i /= 10;
        }
        return s;
    }
}
