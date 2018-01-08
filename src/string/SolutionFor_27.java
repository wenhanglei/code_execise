package string;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class SolutionFor_27 {
	/*
	 * 思路：
	 * 回溯法
	 * 递归和迭代
	 */
	public ArrayList<String> Permutation(String str) {
		//结果变量
		ArrayList<String> res = new ArrayList<String>();
		if(str != null && str.length() > 0 ) {
			recur(res, str, 0);
			Collections.sort(res);
		}
		return res;
    }
	
	/**
	 * 以递归的方法遍历整个str的所有排列组合
	 */
	private void recur(ArrayList<String> res, String str, int lo){
		String newStr = str;
		for(int i = lo; i < str.length(); i++) {
			newStr = swap(str, lo, i);
			if(i == lo || str.charAt(lo) != str.charAt(i))
				recur(res, newStr, lo+1);
		}
		//如果最低位等于str的最高位，则表示遍历到了最底层
		if(lo == str.length()-1)
			res.add(str);
	}
	
	/**
	 * 交换字符串str中下标a，b的字符，返回交换后的字符串
	 */
	private String swap(String str, int a, int b){
		if(a == b) return str;
		StringBuilder strB = new StringBuilder(str);
		char temp = strB.charAt(a);
		strB.setCharAt(a, strB.charAt(b));
		strB.setCharAt(b, temp);
		return strB.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String str = "aa";
		
		SolutionFor_27 solution = new SolutionFor_27();
		ArrayList<String> con = solution.Permutation(str);
		for(int i = 0; i < con.size(); i++) {
			System.out.println(con.get(i));
		}
		
	}
}
