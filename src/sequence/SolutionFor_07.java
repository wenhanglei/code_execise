package sequence;
/**
 * 输入一个整数N，请输出斐波那契数列的第N项。
 *
 */
public class SolutionFor_07 {
	
	//保存下标n为第n项斐波那契数的数组
	private int[] record;
	
	/*
	 * 思路：
	 * 递归和动态规划，要注意递归会造成重复计算问题
	 * 如何避免重复计算
	 */	
	public int Fibonacci(int n) {
//		if(n <= 1) return n;
//		if(record == null){
//			record = new int[n+1];
//			for(int i = 0; i < n+1; i++){
//				record[i] = -1;
//			}
//		}
//		if(n < record.length)
//			return record[n];
//		else
		if(n <=1) return n;
		
		//如果斐波那契数组为null，初始化该斐波那契数组
		if(record == null) {
			record = new int[n+1];
			record[0] = 0;
			record[1] = 1;
		}
		//-------------------------------------------------
		//扩容不科学！！！！！！！！！！！！！！！！
		//如果斐波那契数组的项数小于当前项要求的斐波那契项数，重新创建新的斐波那契数组
		if(record.length <= n) {
			int[] temp = new int[n+1];
			for(int i = 0; i < record.length; i++)
				temp[i] = record[i];
			record = temp;
		}
		//---------------------------------------------------
		if(record[n] != 0) return record[n];
		//计算各项斐波那契数
		for(int i = 2; i < n+1; i++) {
			record[i] = record[i-1] + record[i-2];
		}
		return record[n];
		
		
		//------------------------------------------------
		//这是动态规划的解决方案
//		int[] record = new int[n+1];
//		record[0] = 0;
//		record[1] = 1;
//		for(int i = 2; i < n+1; i++)
//			record[i] = record[i-1] + record[i-2];
//		return record[n];
		//--------------------------------------------------
    }
//	public int Fibonacci(int n) {
//		if(n <= 1) return n;
//		int[] record = new int[n+1];
//		record[0] = 0;
//		record[1] = 1;
//		for(int i = 2; i < n+1; i++)
//			record[i] = record[i-1] + record[i-2];
//		return record[n];
//    }
//	public int Fibonacci(int n) {
//		if(n <= 1) return n;
//		return Fibonacci(n-1)+Fibonacci(n-2);
//    }
	
	public static void main(String[] args) {
		SolutionFor_07 solution = new SolutionFor_07();
		for(int i = 0; i <= 39; i++) {
			System.out.println(solution.Fibonacci(i));
		}
	}
}
