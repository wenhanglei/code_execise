package array;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class SolutionFor_51 {
	/*
	 * 思路:
	 * 后缀数组思想
	 * 
	 */
	public int[] multiply(int[] A) {
		//结果数组
		int[] res = new int[A.length];
		if(A.length == 0) return res;
		
		int acc = 1;
		for(int i = 0; i < A.length; i++){
			res[i] = acc;
			acc *= A[i];
		}
		acc = 1;
		for(int i = A.length-1; i >= 0; i--){
			res[i] *= acc;
			acc *= A[i];
		}
		return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5};
		SolutionFor_51 solution = new SolutionFor_51();
		int[] res = solution.multiply(arr);
	}
}
