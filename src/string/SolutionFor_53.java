package string;

import java.util.Stack;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author wenhanglei
 */
public class SolutionFor_53 {
	public boolean isNumeric(char[] str) {
		//符号栈
		Stack<Character> stack = new Stack<Character>();
        return isNumeric(str, 0, stack);
    }
	
	public boolean isNumeric(char[] str, int i, Stack<Character> stack){
		if(i != str.length){
			char c = str[i];
			if(c >= '0' && c <= '9')
				return isNumeric(str, i+1, stack);
			else if(c == '+' || c == '-'){
				if(!stack.isEmpty()){
					char oper = stack.peek();
					if(oper == '+' || oper == '-')
						return false;
				}else if(i != 0) return false;
				stack.push(c);
				return isNumeric(str, i+1, stack);
			}else if(c == '.'){
				if(!stack.isEmpty()){
					if(stack.contains('e') || stack.contains('E') || stack.peek() == '.')
						return false;
				}
				stack.push(c);
				return isNumeric(str, i+1, stack);
			}else if(c == 'e' || c == 'E'){
				if(!stack.isEmpty()){
					if(stack.peek() == 'e' || stack.peek() == 'E')
						return false;
				}
				stack.push(c);
				return isNumeric(str, i+1, stack);
			}
			return false;
		}else {
			if(str[i-1] == 'e' || str[i-1] == 'E') return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		/**
		 * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
		 */
		String str = "1+123";
		SolutionFor_53 sol = new SolutionFor_53();
		System.out.println(sol.isNumeric(str.toCharArray()));
		
	}
}
