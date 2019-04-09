package demo;

public class No38 {
	public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if(len == 0)
            return 0;
        int first = getFirst(array, k, 0, len-1);
        int last = getLast(array, k, 0, len-1);
        if(first != -1 && last != -1){
            return last - first + 1;
        }
        return 0;
        
//        return biSearch(array, k+0.5) - biSearch(array, k-0.5);
    }

	public int getFirst_R(int [] array, int k, int start, int end){
        if(start > end)
        	return -1;
        
		int mid = (start + end) / 2;
		int midData = array[mid];
		
		if(midData == k) {
			if((mid > 0 && array[mid - 1] != k) || mid == 0)
				return mid;
			else
				end = mid - 1;
		}
		else if(midData > k)
			end = mid - 1;
		else
			start = mid + 1;
		
		return getFirst_R(array, k, start, end);
    }
	
    public int getFirst(int [] array, int k, int start, int end){
        int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(k <= array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if(start < array.length && array[start] == k)
            return start;
        else
            return -1;
    }
    // ѭ��
    public int getLast(int [] array, int k, int start, int end){
        int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(k >= array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(end >= 0 && array[end] == k)
            return end;
        else
            return -1;
    }
    
//    ������һ�������˼·����Ϊdata�ж����������������ǲ�������k������λ�ã�����ֱ������k-0.5��k+0.5��������Ӧ��
//    �����λ�ã�Ȼ��������ɡ�
    public int biSearch(int [] array, double k){
        int start  = 0, end = array.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
