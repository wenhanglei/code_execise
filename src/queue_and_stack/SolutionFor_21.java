package queue_and_stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class SolutionFor_21 {
	/*
	 * 思路：
	 * 
	 */
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		//返回的结果
		boolean res = true;
		//序列pushA的用于比较的当前下标
		int a = 0;
		//序列popA用于比较的当前下标
		int b = 0;
		stack.push(pushA[a++]);
		while(!stack.isEmpty() && res){
			while(stack.peek() != popA[b]){
				if(a >= pushA.length) {
					res = false;
					break;
				}
				stack.push(pushA[a++]);
			}
			stack.pop();
			b++;
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] pushA = {1, 2, 3, 4, 5};
		int[] popA = {4, 3, 5, 1, 2};
		
		SolutionFor_21 solution = new SolutionFor_21();
		
		System.out.println(solution.IsPopOrder(pushA, popA));
	}
}
