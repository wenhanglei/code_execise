package string;
/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class SolutionFor_52 {
	
	/*
	 * 思路：
	 * 递归思想
	 */
	public boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null){
			return false;
		}
		return matchTwo(str, 0, pattern, 0);
    }
	
	private boolean matchTwo(char[] str, int a, char[] pattern, int b){
		//合法检测
		if(a == str.length && b == pattern.length)
			return true;
		//非法检测
		if(b == pattern.length && a < str.length)
			return false;
			
		if((b < pattern.length-1 && pattern[b+1] != '*') || b == pattern.length-1){
			if((a < str.length && str[a] == pattern[b]) || pattern[b] == '.')
				return matchTwo(str, a+1, pattern, b+1);
			else return false;
		}
		
		if( b < pattern.length-1 && pattern[b+1] == '*'){
			boolean one = matchTwo(str, a, pattern, b+2);
			boolean two = false;
			boolean three = false;
			if(a < str.length && (str[a] == pattern[b] || pattern[b] == '.')){
				two = matchTwo(str, a+1, pattern, b);
				three = matchTwo(str, a+1, pattern, b+2);
			}
			return one || two || three;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "";
		String pat = ".";
		SolutionFor_52 solution = new SolutionFor_52();
		boolean res = solution.match(str.toCharArray(), pat.toCharArray());
		System.out.println(res);
	}
}
