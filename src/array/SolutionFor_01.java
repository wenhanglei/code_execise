package array;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author Administrator
 *
 */
public class SolutionFor_01 {
	/*
	 * 思路：
	 * 矩阵向上和向右都是递增的
	 * 
	 */
	public static boolean find(int[][] array, int i) {
		
		int r = array.length;                      //数组多少行
		int c = array[0].length;                   //数组多少列
		
		//当前用于比较的数据
		int current;
		for(int j = r-1, k = 0; j >= 0 && k < c;){
			current = array[j][k];
			if(current == i) return true;
			else if(i < current)
				j = j-1;
			else if(i > current)
				k = k+1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] array = {
				{0, 2, 3, 4, 5, 6},
				{1, 3, 4, 5, 6, 7},
				{2, 4, 5, 6, 7, 8},
				{3, 5, 6, 7, 8, 9},
				{4, 6, 7, 8, 9, 10}
		};
		System.out.println(find(array, 11));
	}
}