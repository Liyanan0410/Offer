package demo;

public class No46 {
//	累加不能用循环的话，那就试试递归吧。
//	判断递归的终止条件不能用 if 和 switch，那就用短路与代替。
//	(n > 0) && (sum += Sum_Solution(n-1))>0
//	只有满足n > 0的条件，&&后面的表达式才会执行。
	public int Sum_Solution(int n) {
        int sum = n;
        boolean t = (n > 0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
