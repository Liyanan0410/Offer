package demo;
import java.util.HashMap;

public class No35 {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(len == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i = 0; i < len; i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
    
    public int FirstNotRepeatingChar2(String str) {
        int len = str.length();
        if(len == 0)
            return -1;
        char [] s = str.toCharArray();
        int [] m = new int[256];
        for(int i = 0; i < len; i++){
            m[s[i]]++;
        }
        for(int i = 0; i < len; i++){
            if(m[s[i]] == 1)
                return i;
        }
        return -1;
    }
}
