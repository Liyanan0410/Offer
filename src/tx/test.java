package tx;

import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int money = Integer.parseInt(str[0]);
        int nums = Integer.parseInt(str[1]);
        Integer[] coinValues = new Integer[nums];
        for (int i = 0; i < nums; i++) {
            coinValues[i] = Integer.parseInt(scan.nextLine());
        }
        Arrays.sort(coinValues, (o1, o2) -> o2 - o1);
        System.out.println(mincoins(money, nums, coinValues));
        scan.close();
	}

	public static Integer mincoins(int money, int nums, Integer[] coinValues) {
        if (coinValues[nums - 1] != 1)
            return -1;
        int coinnum = 0;
        int maxvalue = 0;
        int[] coinnums = new int[money + 1];
        coinnums[0] = 0;
        for (int i = 1; i <= money; i++) {
            if (i > maxvalue) {
                for (int j = 0; j < coinValues.length; j++) {
                    int coinValue = coinValues[j];
                    if (i >= coinValue) {
                        coinnum++;
                        maxvalue += coinValue;
                        break;
                    }
                }
                coinnums[i] = coinnum;
            } else {
                coinnums[i] = coinnums[i - 1];
            }
        }
        return coinnums[money];
    }
}
