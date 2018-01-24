package string;

import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class SolutionFor_44 {
	/*
	 * 思路：
	 * 栈
	 */
	public String ReverseSentence(String str) {
        int len = str.length();
        if(str == null || len < 2) return str;
        //结果变量
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i = len-1; i >= 0; i--) {
        	char c = str.charAt(i);
        	if(c == ' '){
        		while(!stack.isEmpty()) sb.append(stack.pop());
        		sb.append(c);
        	}else
        		stack.push(c);
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_44 solution = new SolutionFor_44();
		String str = solution.ReverseSentence("student. a am I");
	}

}
