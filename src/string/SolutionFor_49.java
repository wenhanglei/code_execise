package string;

import java.io.StreamTokenizer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class SolutionFor_49 {
	public int StrToInt(String str) {
        //结果变量
		int res = 0;
		for(int i = str.length()-1, j=1; i >= 0; i--){
			int c = (int)str.charAt(i)-48;
			if(0 <= c && c <= 9){
				res += c*j;
				j *= 10;
			}else if(c == -5 && i == 0) {                       //如果是+号
				return res;
			}else if(c == -3 && i == 0) {                       //如果是-号
				return 0-res;
			}else return 0;
		}
		return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String str = "1a33";
		SolutionFor_49 solution = new SolutionFor_49();
		int res = solution.StrToInt(str);
		System.out.println(res);
	}
}
