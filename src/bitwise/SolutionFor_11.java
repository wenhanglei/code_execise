package bitwise;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class SolutionFor_11 {
	/*
	 * 思路：
	 * 
	 */
	public int NumberOf1(int n) {
		int count = 0;
		while(n!=0){
			if((n&1) == 1) count++;
			n >>>= 1;
		}
		return count;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int min = Byte.MIN_VALUE;
		int max =  Byte.MAX_VALUE;
		int sum = Byte.SIZE;
		
		int a = 0xbe;           //b0  1011 1110
		int b = -0xbe;          //b1 0100 0010
		int c = 1;
		
		System.out.println(Integer.toBinaryString(b));
		SolutionFor_11 solution = new SolutionFor_11();
		System.out.println(solution.NumberOf1(b));
	}
}
