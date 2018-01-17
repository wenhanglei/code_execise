package array;
/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class SolutionFor_37 {
	/*
	 * 思路：
	 * 二分查找
	 */
	public int GetNumberOfK(int [] array , int k) {
		//边界条件判断
		if(array == null || array.length == 0) return 0;
		//二分查找最左边的k的下标
		int leftIndex = binarySearchLeft(array, 0, array.length-1, k);
		//二分查找最右边的k的下标
		int rightIndex = binarySearchRight(array, 0, array.length-1, k);
		
		if(leftIndex == -1 || rightIndex == -1)
			return 0;
		
		return rightIndex-leftIndex+1;
    }
	
	private int binarySearchLeft(int[] arr, int lo, int hi, int k) {
		//边界条件判断
		if(arr == null || arr.length == 0) return -1;
		while(lo <= hi){
			if(arr[lo] == k) return lo;
			int mid = lo + (hi-lo)/2;
			if(arr[mid] < k) lo = mid+1;
			else if(arr[mid] > k) hi = mid-1;
			else lo++;
		}
		return -1;
	}
	
	private int binarySearchRight(int[] arr, int lo, int hi, int k) {
		//边界条件判断
		if(arr == null || arr.length == 0) return -1;
		while(lo <= hi){
			if(arr[hi] == k) return hi;
			int mid = lo + (hi-lo)/2;
			if(arr[mid] < k) lo = mid+1;
			else if(arr[mid] > k) hi = mid-1;
			else hi--;
		}
		return -1;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 3, 3, 4, 5};
		SolutionFor_37 solution = new SolutionFor_37();
		System.out.println(solution.GetNumberOfK(arr, 6));
	}
}
