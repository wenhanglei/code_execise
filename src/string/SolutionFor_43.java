package string;
/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class SolutionFor_43 {
	/*
	 * 思路：
	 * 求模
	 */
	public String LeftRotateString(String str,int n) {
		//边界判断
		if(str == null || str.length()==0) return "";
		//字符串长度
		int len = str.length();
		n %= len;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			sb.append(str.charAt((n+i)%len));
		}
        return sb.toString();
    }
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcXYZdef";
		SolutionFor_43 solution = new SolutionFor_43();
		String res = solution.LeftRotateString(str, 3);
	}
}
