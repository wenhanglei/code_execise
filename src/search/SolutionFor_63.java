package search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？ 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * @author wenhanglei
 */
public class SolutionFor_63 {

	// 输入数字计数器
	private int count;
	// 小根堆
	private PriorityQueue<Integer> pq1 = new PriorityQueue<>();
	// 大根堆
	private PriorityQueue<Integer> pq2 = new PriorityQueue<>(11,
			new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

	public void Insert(Integer num) {
		if(count % 2 == 0){
			pq1.offer(num);
			Integer i = pq1.poll();
			pq2.offer(i);
		}else{
			pq2.offer(num);
			Integer i = pq2.poll();
			pq1.offer(i);
		}
		count++;
	}

	public Double GetMedian() {
		if(count % 2 == 0){
			return (pq1.peek() + pq2.peek())/2.0;
		}else{
			return (double)pq2.peek();
		}
	}

	/**
	 * 测试函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SolutionFor_63 sol = new SolutionFor_63();
		sol.Insert(3);
		sol.Insert(4);
		sol.Insert(5);
		sol.Insert(6);
		sol.Insert(7);
		double res = sol.GetMedian();
		System.out.println(res);
	}
}
