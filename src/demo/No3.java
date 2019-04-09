package demo;

public class No3 {
	public static void main(String[] args) {
		int s[][] = new int[4][4];
		s[0][0] = 1;
		s[0][1] = 2;
		s[0][2] = 8;
		s[0][3] = 9;
		s[1][0] = 2;
		s[1][1] = 4;
		s[1][2] = 9;
		s[1][3] = 12;
		s[2][0] = 4;
		s[2][1] = 7;
		s[2][2] = 10;
		s[2][3] = 13;
		s[3][0] = 6;
		s[3][1] = 8;
		s[3][2] = 11;
		s[3][3] = 15;
				
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[0].length; j++) {
				System.out.println(s[i][j]);
			}
		}
		
		int target = 90;
		boolean flag = Find(target, s);
		System.out.println(flag);
	}
	
    public static boolean Find(int target, int [][] array) {
        if(array.length==0 || array[0].length==0)
            return false;
        int m = array[0].length-1;
        int n = 0;
        int temp = array[n][m];
        while(target != temp){
            if(m>0 && n<array.length-1){
                if(target>temp){
                    n = n + 1;
                }else if(target<temp){
                    m = m - 1;
                }
                temp = array[n][m];
            }else{
                return false;
            }
        }
        return true;
    }
}