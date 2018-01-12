package integrity;
/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class SolutionFor_31 {
	public int NumberOf1Between1AndN_Solution(int n) {
		//边界情况
		if(n < 1) return 0;
		//乘法因子m为1， 10， 100， 1000
		int sum = 0;
		for(long m = 1; m <= n; m*=10){
			sum += (n/m+8)/10*m + ((n/m%10==1)?(n%m+1):0);
		}
	    return sum;
    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int i1 = 13;
		int i2 = 1300;
		int i3 = 3141592;
		
		SolutionFor_31 solution = new SolutionFor_31();
		
		System.out.println(solution.NumberOf1Between1AndN_Solution(i1));
//		System.out.println(solution.NumberOf1Between1AndN_Solution(i2));
//		System.out.println(solution.NumberOf1Between1AndN_Solution(i3));
	}
}
