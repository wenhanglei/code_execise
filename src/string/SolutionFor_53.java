package string;
/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author wenhanglei
 */
public class SolutionFor_53 {
	public boolean isNumeric(char[] str) {
		//边界判断
		if(str == null || str.length == 0) return false;
		
		char curr = str[0];
		//如果第一个字符符合规则
		if(curr == 43 || curr == 45 || (curr > 47 && curr < 58)){
			
		}
		
        return false;
    }
	
	private boolean isNumeric(char[] str, int i){
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println((int)'+');
		System.out.println((int)'-');
		System.out.println((int)'0');
		System.out.println((int)'9');
	}
}
