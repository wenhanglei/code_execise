package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		if (num == null)
			return ret;
		PriorityQueue<Integer> max_pq = new PriorityQueue<>(11,
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});
		int lo = 0;
		int hi = 0;
		for(; hi < size; hi++){
			max_pq.add(num[hi]);
		}
		while(hi < num.length){
			ret.add(max_pq.peek());
			max_pq.remove(num[lo]);
			max_pq.add(num[++hi]);
		}

		return null;
	}
}
