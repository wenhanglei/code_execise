package array;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class SolutionFor_29 {
	/*
	 * 思路：
	 * 败者树
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(k > input.length) return list;
		MinPQ pq = new MinPQ(input);
		for(int i = 0; i < k; i++) {
			list.add(pq.min());
		}
		return list;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
		MinPQ pq = new MinPQ(array);
		System.out.println(pq.min());
		System.out.println(pq.min());
		System.out.println(pq.min());
	}
	
	static class MinPQ {
		
		private int[] pq;
		private int N;
		
		/**
		 * 最小值优先队列构造函数
		 */
		public MinPQ(int[] pq) {
			N = pq.length;
			for(int i = N/2; i > 0; i--){
				sink(pq, i);
			}
			this.pq = pq;
		}
		
		/**
		 * @return 最小的值
		 */
		public int min() {
			int res = pq[0];
			pq[0] = pq[N-1];
			sink(pq, 1);
			return res;
		}
		
		/**
		 * 将index索引位置的数向下调整
		 * @param pq
		 * @param index
		 */
		public void sink(int[] pq, int index) {
			while(index*2 < pq.length){
				int left = index*2-1;
				int right = index*2;
				index--;
				int min = left;
				if(right < pq.length && pq[left] > pq[right])
					min = right;
				if(pq[index] > pq[min]){
					int temp = pq[min];
					pq[min] = pq[index];
					pq[index] = temp;
				}
				index = min+1;
			}
		}
		
		public void swap(int[] arr, int a, int b) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
}
