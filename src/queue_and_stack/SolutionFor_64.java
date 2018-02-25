package queue_and_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author wenhanglei
 */
public class SolutionFor_64 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> ret = new ArrayList<>();
		// 检查边界
		if (num == null || size == 0)
			return ret;
		//双端队列
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int begin;
		for(int i = 0; i < num.length; i++){
			begin = i - size + 1;
			
			if(deque.isEmpty())
				deque.addLast(i);
			else{
				//判断队列头结点是否失效
				if(deque.peekFirst() < begin)                       //如果头结点失效，移除头结点
					deque.removeFirst();
				//在队列中从后向前移除小于当前值的数的下标
				while(!deque.isEmpty() && num[deque.peekLast()] < num[i]){
					deque.removeLast();
				}
				//添加当前值的下标
				deque.addLast(i);
			}
			//添加结果变量
			if(begin >= 0)
				ret.add(num[deque.peekFirst()]);
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
		
		SolutionFor_64 sol = new SolutionFor_64();
		ArrayList<Integer> maxInWindows = sol.maxInWindows(num, 3);
		System.out.println(Arrays.toString(maxInWindows.toArray()));
	}
}
