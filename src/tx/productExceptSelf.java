package tx;

public class productExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = fun(nums);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
	
	public static int[] fun(int[] nums) {
		int length = nums.length;
		int[] outputs = new int[length];
        int[] temps = new int[length];
		if(length == 0) {
			return outputs;
		}
        
        outputs[0] = 1;
        temps[0] = 1;
        for(int i = 1; i < length; i++) {
        	outputs[i] = nums[i-1]*outputs[i-1];
        	temps[i] = nums[length-i]*temps[i-1];
        }
        
        for(int i = 0; i < length; i++) {
        	outputs[i] *= temps[length-i-1];
        }
        
        return outputs;
    }

}
