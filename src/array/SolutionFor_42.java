package array;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class SolutionFor_42 {
	/*
	 * 思路：
	 * 双指针操作 + 动态规划
	 */
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		//结果变量
		ArrayList<Integer> res = new ArrayList<Integer>();
		//边界判定
		if(array == null || array.length < 2) return res;
		
        return FindNumberSWithSum(array, 0, array.length-1, sum);
    }
	
	/**
	 * 查找lo到hi之间第一对和为sum的两个数
	 */
	private ArrayList<Integer> FindNumberSWithSum(int[] array, int lo, int hi, int sum){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp = array[lo]+array[hi];
		while(temp!=sum && lo < hi){
			if(temp < sum) lo++;
			else hi--;
			temp = array[lo] + array[hi];
		}
		if(lo >= hi) return list;
		int a = array[lo];
		int b = array[hi];
		list.add(a);
		list.add(b);
		ArrayList<Integer> last = FindNumberSWithSum(array, lo+1, hi-1, sum);
		if(!last.isEmpty()){
			if(last.get(0)*last.get(1) >= a*b) return list;
			else return last;
		}else return list;
		
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		SolutionFor_42 solution = new SolutionFor_42();
		solution.FindNumbersWithSum(arr, 21);
	}
}
