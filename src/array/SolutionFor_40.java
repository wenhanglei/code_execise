package array;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class SolutionFor_40 {
	/*
	 * 思路：
	 * hashmap保存对应的数的出现次数
	 */
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}else
				map.put(array[i], 1);
		}
		int i = 0;
		for(Entry ent : map.entrySet()){
			if((int)ent.getValue() == 1){
				if(i == 0) {
					num1[0] = (int) ent.getKey();
					i++;
				}else{
					num2[0] = (int) ent.getKey();
				}
			}
		}
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3 , 2, 4, 4, 5, 6, 6};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		SolutionFor_40 solution = new SolutionFor_40();
		solution.FindNumsAppearOnce(arr, num1, num2);
		System.out.println(num1[0]+ " " + num2[0]);
	}
}
