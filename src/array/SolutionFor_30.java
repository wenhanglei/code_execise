package array;
/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class SolutionFor_30 {
	/*
	 * 思路：
	 * 动态规划
	 * 
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
		//数组长度
		int N = array.length;
		//结果变量
		int res = array[N-1];
		//边界条件判断
		if(array == null || array.length < 2) return res;
		//后缀数组的和, 最大值， 最小值
		int sum = 0, max = 0, min = 0;
		//从后向前遍历该数组
		for(int i = N-1; i >= 0; i--){
			sum += array[i];
			if(sum >= max || sum-min > res){
				max = sum;
				res = max - min;
			}
			if(sum < min)
				min = sum;
		}
		//返回结果
		return res;
    }
	
	private void arraySum(int[] array){
		int sum = 0;
		for(int i = array.length - 1; i >= 0; i--) {
			sum += array[i];
			System.out.println(sum);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
		int[] arr1 = {-2, -8, -1, -5, -9};
		int[] arr2 = {1, -10};
		int[] arr3 = {-10, 1};
		SolutionFor_30 solution = new SolutionFor_30();
		System.out.println(solution.FindGreatestSumOfSubArray(arr3));
//		solution.arraySum(arr3);
	}
}
