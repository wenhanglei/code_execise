package array;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class SolutionFor_35 {
	/*
	 * 思路： 归并排序改进
	 */
	public long InversePairs(int[] array) {
		if (array == null || array.length < 2) return 0;
		int[] ass = new int[array.length];
		int res = merge(array, ass, 0, array.length);
		return res;
	}

	/**
	 * 归并排序，lo最低位，hi最高位的后一位
	 * @param lo
	 * @param hi
	 */
	private int merge(int[] arr, int[] ass, int lo,int hi) {
		if(hi<=lo+1) return 0;
		int num = 0;                                     //返回的逆序对数量
		int mid = lo + (hi-lo)/2;
		num += merge(arr, ass, lo, mid)%1000000007;
		num += merge(arr, ass, mid, hi)%1000000007;
		int i = mid-1;
		int j = hi-1;
		int ptr = hi-1;
		while(i >= lo && j >= mid){
			if(arr[i] <= arr[j]){                         //如果左边的小于等于右边的
				ass[ptr--] = arr[j--];
			}else{                                       //如果右边的小于左边的
				ass[ptr--] = arr[i--];
				num += j-mid+1;
				if(num >= 1000000007){
					num %= 1000000007;
				}
			}
		}
		if(i < lo){                                      //如果左边的先遍历完
			while(j >= mid)
				ass[ptr--] = arr[j--];
		}
		if(j < mid){
			while(i >= lo)
				ass[ptr--] = arr[i--];
		}
		//修改原数组的值
		for(i = lo; i < hi; i++) {
			arr[i] = ass[i];
		}
		return num%1000000007;
	}


	/**
	 * 判断下标a，b是否是逆序对
	 */
	private boolean isInversePair(int[] arr, int a, int b) {
		if (arr[a] > arr[b])
			return true;
		else
			return false;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 0 };
		int[] arr1 = {7, 5, 6, 4};
		SolutionFor_35 solution = new SolutionFor_35();
		System.out.println(solution.InversePairs(arr));
	}
}
