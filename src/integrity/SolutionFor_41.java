package integrity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good
 * Luck!
 */
public class SolutionFor_41 {
	/*
	 * 思路：
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		//结果list
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//判断边界条件
		if(sum < 2) return res;
		//当前序列的ArrayList
		LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<Integer>();
		int len = sum/2+1;
		int currSum = 0;
		for(int i = len; i > 0; i--){
			if(currSum > sum){                      //如果队列中的序列的和大于sum
				currSum -= queue.poll();
			}
			queue.add(i);
			currSum += i;
			if(currSum == sum){               //如果当前队列中的序列和等于sum
				//保存当前序列的逆序列到结果list中
				res.add(getDescendSequence(queue));
			}
		}
		Collections.reverse(res);
		return res;
	}
	
	private static ArrayList<Integer> getDescendSequence(LinkedBlockingDeque<Integer> queue){
		if(queue == null) return null;
		Iterator<Integer> descendingIterator = queue.descendingIterator();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(descendingIterator.hasNext()){
			res.add(descendingIterator.next());
		}
		return res;
	}


	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_41 solution = new SolutionFor_41();
		solution.FindContinuousSequence(20);
	}
}
