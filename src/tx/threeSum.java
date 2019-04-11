package tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> fun(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // �ȶ������������Ȼ������˫ָ���������֮�͡�O(n*n)
        Arrays.sort(nums);
        // ע�⣺ֻ����������ſ�����������Ľⷨ
        for (int i = 0; i < nums.length; i++) {
            // �Ե�һ��Ԫ��ȥ��(ȥ�ص�Ŀ���Ƿ�ֹ�����ظ���Ԫ����.)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    // �Եڶ���Ԫ��ȥ�ش���
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }else if (sum > 0) {
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
