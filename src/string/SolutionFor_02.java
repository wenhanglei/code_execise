package string;
/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class SolutionFor_02 {
	/*
	 * 思路：
	 * 方案一：使用额外的StringBuffer辅助
	 * 方案二：不使用辅助StringBuffer从后向前插入即可
	 */
	public static String replaceSpace(StringBuffer str) {
		//边界检查
		if(str == null) return null;
		for(int i = str.length()-1; i >= 0; i--){
			if(str.charAt(i) == ' '){
				str.delete(i, i+1);
				str.insert(i, "%20");
			}
		}
		return str.toString();
	}
//	public static String replaceSpace(StringBuffer str) {
//		//获取所有字符组成的数组
//		char[] chars = str.toString().toCharArray();
//		//创建用于装载替换后字符串的新数组
//		StringBuffer sb = new StringBuffer();
//		for(int i = 0; i < chars.length; i++) {
//			if(chars[i] == ' ')
//				sb.append("%20");
//			else
//				sb.append(chars[i]);
//		}
//		return sb.toString();
//	}
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy.");
		System.out.println(replaceSpace(str));
	}
}
