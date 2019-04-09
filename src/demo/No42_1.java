package demo;

public class No42_1 {
	public String ReverseSentence(String str) {
        if(str.trim().length() == 0)
            return str;
        String [] temp = str.split(" ");
        String res = "";
        for(int i = temp.length - 1; i >= 0; i--){
            res += temp[i];
            if(i != 0)
                res += " ";
        }
        return res;
    }
}
