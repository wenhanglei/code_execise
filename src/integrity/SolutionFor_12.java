package integrity;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class SolutionFor_12 {
	/*
	 * 思路：
	 * 
	 */
	public double Power(double base, int exponent) {
		double res = 1, curr = base;
		int exp = exponent;
		if(exp < 0) 
			exp = -exponent;
		else if(exp == 0)
			exp = 0;
		if(exp == 0) return 1;
		//快速幂
		while(exp != 0){
			if((exp&1) == 1) 
				res *= curr;
			curr *= curr;
			exp >>= 1;
		}
		return (exponent > 0)?res:1.0/res;
	}
	
	public static void main(String[] args) {
		// 11 1011
		SolutionFor_12 solution = new SolutionFor_12();
		System.out.println(solution.Power(2.0, 3));
		System.out.println(solution.Power(2.0, -3));
		System.out.println(solution.Power(2.0, 0));
	}
}
