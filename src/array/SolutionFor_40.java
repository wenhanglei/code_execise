package array;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class SolutionFor_40 {
	/*
	 * 思路：
	 * 一个数和它本身异或为0
	 */
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		//判断边界条件
		if(array == null || array.length < 2){
			num1[0] = -1;
			num2[0] = -1;
		}
		int len = array.length, res = 0;
		for(int i = 0; i < len; i++) {
			res ^= array[i];
		}
		int x = Integer.highestOneBit(res);
		int res1 = 0;
		int res2 = 0;
		for(int i = 0; i < len; i++) {
			if((array[i] & x) == x){
				res1 ^= array[i];
			}else{
				res2 ^= array[i];
			}
		}
		num1[0] = res1;
		num2[0] = res2;
    }
	
	/**
	 * 找出数组中只出现一次的数
	 * @param arr
	 * @return
	 */
	public static int fintOneTimeNum(int[] arr) {
		if(arr == null) return -1;
		int len = arr.length, res = 0;
		for(int i = 0; i < len; i++){
			res ^= arr[i];
		}
		return res;
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
		
//		int[] arr = {3, 2, 3};
//		System.out.println(fintOneTimeNum(arr));
	}
}
