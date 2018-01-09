package array;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class SolutionFor_28 {
	/*
	 * 思路：
	 * map次数计数
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
		if (array == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++) {
        	if(map.get(array[i]) == null){
        		map.put(array[i], 1);
        	}else{
        		map.put(array[i], map.get(array[i])+1);
        	}
        }
        for(Integer i : map.keySet()){
        	if(map.get(i) > array.length/2)
        		return i;
        }
        return 0;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2};
		
		SolutionFor_28 solution = new SolutionFor_28();
		System.out.println(solution.MoreThanHalfNum_Solution(array));
	}
}
