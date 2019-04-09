package demo;
import java.util.ArrayList;
import java.util.Collections;

public class No28 {
    ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if(str == null)
            return res;
        PermutationHelper(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }
    public void PermutationHelper(char[] str, int i){
        if(i == str.length - 1){
            res.add(String.valueOf(str));
        }else{
            for(int j = i; j < str.length; j++){
                if(j!=i && str[i] == str[j])
                    continue;
                swap(str, i, j);
                PermutationHelper(str, i+1);
                swap(str, i, j);
            }
        }
    }
    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}