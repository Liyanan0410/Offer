package demo;

public class No31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;
        int cur = array[0], max = array[0];
        for(int i=1; i<array.length; i++){
            cur = cur > 0 ? cur + array[i] : array[i];
            if(max < cur)
                max = cur;
        }
        return max;
    }
}
