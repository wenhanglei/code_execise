package array;
/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class SolutionFor_33 {
	public int GetUglyNumber_Solution(int index) {
		if(index < 7) return index;
		int[] arr = new int[index];
		for(int i = 0; i < 6; i++){
			arr[i] = i+1;
		}
		int m = 6;
		int index_m2 = 0;
		int index_m3 = 0;
		int index_m5 = 0;
		while(m < index){
			int m2 = 2*arr[index_m2];
			while(m2 <= arr[m-1]){
				m2 = 2*arr[++index_m2];
			}
			int m3 = 3*arr[index_m3];
			while(m3 <= arr[m-1]){
				m3 = 3*arr[++index_m3];
			}
			int m5 = 5*arr[index_m5];
			while(m5 <= arr[m-1]){
				m5 = 5*arr[++index_m5];
			}
			arr[m++] = minNum(m2, m3, m5);
		}
		return arr[index-1];
    }
	
	private int minNum(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	
	
	
	private boolean isUglyNumber(int num) {
		if(num == 0) return false;
		while(num%2 == 0){
			num /= 2;
		}
		while(num%3 == 0){
			num /= 3;
		}
		while(num%5 == 0){
			num /= 5;
		}
		return num == 1? true: false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_33 solution = new SolutionFor_33();
		System.out.println(solution.GetUglyNumber_Solution(10));
	}
}
