package demo;
import java.util.Arrays;

public class No44 {
	public boolean isContinuous(int [] numbers) {
        int zero = 0, dis = 0;
        if(numbers.length != 5)
            return false;
        Arrays.sort(numbers);
        for(int i = 0; i < 4; i++){
            if(numbers[i] == 0){
                zero ++;
                continue;
            }
            if(numbers[i] == numbers[i+1])
                return false;
            if(numbers[i+1] - numbers[i] > 1){
                dis += numbers[i+1] - numbers[i] - 1;
            }
        }
        if(zero >= dis)
            return true;
        else
            return false;
    }
}
