package sequence;
/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SolutionFor_47 {
	private int sum;
	/*
	 * 思路：
	 * 
	 */
	public int Sum_Solution(int n) {
		foo(n);
		return sum;
    }
	
	private boolean foo(int n){
		sum += n;
		return n > 0 && foo(n-1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_47 solution = new SolutionFor_47();
		int sum = solution.Sum_Solution(10);
	}
}
