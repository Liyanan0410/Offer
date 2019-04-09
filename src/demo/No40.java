package demo;
import java.util.HashMap;

public class No40 {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(temp.containsKey(array[i]))
                temp.remove(array[i]);
            else
                temp.put(array[i], 1);
        }
        int [] a = new int [array.length];
        int i = 0;
        for(Integer k: temp.keySet()){
            a[i] = k;
            i++;
        }
        num1[0] = a[0];
        num2[0] = a[1];
    }
	
	public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        num1[0] = 0;
        num2[0] = 0;
        if(array.length == 0)
            return;
        int num = 0;
        for(int i = 0; i < array.length; i++){
            num ^= array[i];
        }
        int index = 0;
        while((num & 1) == 0 && index < 8){
            num = num >> 1;
            index ++;
        }

        for(int i = 0; i < array.length; i++){
            if(isa1(array[i], index))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    public boolean isa1(int i, int index){
        i = i >> index;
        return (i & 1) == 1;
    }
}
