package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SolutionFor_32 {
	public String PrintMinNumber(int [] numbers) {
		if(numbers.length < 0 || numbers == null) return null;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				int a = Integer.parseInt(str1+str2);
				int b = Integer.parseInt(str2+str1);
				if(a > b) return 1;
				else if(a < b) return -1;
				else return 0;
			}
		});
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < list.size(); i++) {
			res.append(list.get(i));
		}
		return res.toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {3, 32, 321};
		int[] nums1 = {3, 5, 1, 4, 2};
		SolutionFor_32 solution = new SolutionFor_32();
		System.out.println(solution.PrintMinNumber(nums1));
	}
}
