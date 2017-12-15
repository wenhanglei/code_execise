package queue_and_stack;

import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class SolutionFor_05 {
	/*
	 * 思路：
	 * 出队的时候把第一个栈中的所有元素移动到第二个栈中再从第二个栈中出栈这完成出队操作
	 * 反之亦然
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	//判读用于出队的stack2是否为空
        //如果不为空则stack2中的元素全部出栈到stack1中
    	while(!stack2.isEmpty())
    		stack1.push(stack2.pop());
    	//新元素入栈到stack1中
    	stack1.push(node);
    }
    
    public int pop() {
    	//判断用于入队的stack1是否为空
    	//如果不为空则stack1中的元素全部出栈到stack2中
    	while(!stack1.isEmpty())
    		stack2.push(stack1.pop());
    	//返回出队数据
    	return stack2.pop();
    }
    
    public static void main(String[] args) {
		SolutionFor_05 queue = new SolutionFor_05();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.pop();
		queue.push(4);
		queue.pop();
		queue.push(5);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
