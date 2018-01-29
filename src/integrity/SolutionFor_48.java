package integrity;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class SolutionFor_48 {
	public int Add(int num1,int num2) {
		int result = 0;
        int i = 1;
        while(i != 0){
        	int a = num1&i;
        	int b = num2&i;
        	int r = result&i;
        	result^=a;
        	result^=b;
        	int j = 1;
        	if(a==i) j <<= 1;
        	if(b==i) j <<= 1;
        	if(r==i) j <<= 1;
        	i <<= 1;
        	if(j >= 4) result^=i;
        }
		return result;
    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_48 solution = new SolutionFor_48();
		String a = Integer.toBinaryString(44);
		String b = Integer.toBinaryString(32);
	}
}
