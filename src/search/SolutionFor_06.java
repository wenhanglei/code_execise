package search;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class SolutionFor_06 {
	/*
	 * 思路：
	 * 折半查找
	 */
	public int minNumberInRotateArray(int [] array) {
	    if(array.length == 0) return 0;
	    int lo = 0;
	    int hi = array.length-1;
	    int mid = 0;
	    while(lo < hi-1){
	    	mid = lo + (hi-lo)/2;
	    	if(array[lo] <= array[mid]){
	    		lo = mid;
	    	}else if(array[lo] > array[mid]) {
	    		hi = mid;
	    	}
	    }
	    return array[hi];
    }
	public static void main(String[] args) {
		int[] array1 = {7, 8, 8, 9, 9, 2, 3, 5, 6, 7};
		int[] array2 = {6, 7, 7, 8, 8, 9, 9, 2, 3, 5};
		int[] array3 = {2, 1};
		int[] array4 = {3, 1, 2};
		int[] array5 = {2, 3, 1};
		int[] array6 = {6, 7, 7, 8, 8, 9, 9, 2};
		SolutionFor_06 solution = new SolutionFor_06();
		int i = solution.minNumberInRotateArray(array6);
		System.out.println(i);
	}
}
