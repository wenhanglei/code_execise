package queue_and_stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class SolutionFor_20 {
	//存储数据的数组
	private int[] array = new int[2];
	//最小值
	private int min;
	//栈顶下标
	private int top = 0;
	//栈大小
	private int N;
			
	public void push(int node) {
		if(N == 0) min = node;
		else if(node < min) min = node;
		if(array.length == top) resize(2);
		array[top++] = node;
		N++;
    }
    
    public void pop() {
    	if(N <= 0) return; 
    	if(array.length == top/4) resize(1/2);
        top--;
        N--;
        if(array[top] == min){
        	min = array[top-1];
        	for(int i = 0; i < N-1; i++) {
        		if(array[i] < min) min = array[i];
        	}
        }
    }
    
    public int top() {
    	if(N <= 0) return -1;
        return array[top-1];
    }
    
    public int min() {
        return min;
    }
    
    private void resize(int size){
    	int[] temp = new int[array.length*size];
    	for(int i = 0; i < array.length; i++)
    		temp[i] = array[i];
    	array = temp;
    }
    
    /**
     * 测试函数
     */
    public static void main(String[] args) {
		SolutionFor_20 stack = new SolutionFor_20();
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.min());
	}
}
