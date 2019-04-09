package tx;

public class reverseString {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		fun(s);
	}
	public static void fun(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length-1;
        while(left < right){
        	char temp = s[left];
        	s[left] = s[right];
        	s[right] = temp;
        	left++;
        	right--;
        }
        System.out.println(s);
    }
}
