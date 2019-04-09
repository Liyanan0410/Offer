package pdd;

public class copyCo {

	public static void main(String[] args) {
		int n = 6;
		fun(n);
	}
	
	public static void fun(int n) {
		int base = 4;
		int exp = 1;
		while(n > base*exp) {
			n = n - base*exp;
			exp++;
		}
		int num = 0;
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < exp; j++) {
				num++;
				if(num == n) {
					if(i == 1)
						System.out.println("A");
					if(i == 2)
						System.out.println("B");
					if(i == 3)
						System.out.println("C");
					if(i == 4)
						System.out.println("D");
				}
			}
		}
	}

}
