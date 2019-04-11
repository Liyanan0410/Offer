package tx;

public class maxArea {

	public static void main(String[] args) {
		
	}

	public int fun(int[] height) {
		int max = Integer.MIN_VALUE;
		if(height.length == 0) {
			return 0;
		}
		for(int i = 0; i<height.length; i++) {
			for(int j = i+1; j < height.length; j++) {
				int temp = (j-i)*(height[i] > height[j] ? height[j] : height[i]);
				max = max > temp ? max : temp;
			}
		}
        return max;
    }
}
