package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class SolutionFor_13 {
	/*
	 * 思路：
	 * 
	 */
	public void reOrderArray(int [] array) {
		//准备两个队列
		Queue<Integer> q1 = new LinkedBlockingDeque<Integer>();
		Queue<Integer> q2 = new LinkedBlockingDeque<Integer>();
		for(int i = 0; i < array.length; i++) {
			if(array[i]%2 != 0) q1.add(array[i]);
			else q2.add(array[i]);
		}
		int i = 0; 
		for(Integer j : q1) array[i++]=j;
		for(Integer k : q2) array[i++]=k;
    }
	
	/**
	 * 使用两个队列辅助完成调换位置：
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * 缺点空间复杂度太高了
	 */
/*	public void reOrderArray(int [] array) {
		//准备两个队列
		Queue<Integer> q1 = new LinkedBlockingDeque<Integer>();
		Queue<Integer> q2 = new LinkedBlockingDeque<Integer>();
		for(int i = 0; i < array.length; i++) {
			if(array[i]%2 != 0) q1.add(array[i]);
			else q2.add(array[i]);
		}
		int i = 0; 
		for(Integer j : q1) array[i++]=j;
		for(Integer k : q2) array[i++]=k;
    }*/
	
	/**
	 * 调换位置的函数
	 */
	private void exch(int[] array, int a, int b) {
		//处理异常条件
//		if(a < 0 || b < 0 || a >= array.length || b >= array.length) return;
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] array = {2, 4, 6, 1, 3, 5, 7};
		int[] array1 = {2, 1};
		SolutionFor_13 solution = new SolutionFor_13();
		solution.reOrderArray(array);
		System.out.println(Arrays.toString(array));
		solution.reOrderArray(array1);
		System.out.println(Arrays.toString(array1));
	}
}
