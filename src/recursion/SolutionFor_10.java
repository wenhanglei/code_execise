package recursion;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class SolutionFor_10 {
	//覆盖方法计数器数组，下标表示有几层，对应下标保存有几种覆盖方法
	private int[] counts;
	/*
	 * 思路：
	 * 覆盖2*1的大矩形的时候只有一种方法
	 * 覆盖2*2的大矩形的时候有两种方法
	 * 覆盖2*3的大矩形的时候可以先覆盖一层，也可以覆盖两层，有三种方法
	 * 覆盖2*4的大矩形的时候可以先覆盖一层，也可以覆盖两层，还可以覆盖三层
	 */
	public int RectCover(int target) {
		//如果层数小于等于2返回target
		if(target <= 2) return target;
		//如果计数器数组不存在，初始化计数器数组
		if(counts == null) {
			counts = new int[target];
			counts[0] = 0;
			counts[1] = 1;
			counts[2] = 2;
		}
		//如果计数器数组的长度不够，则扩容
		if(counts.length <= target) {
			int[] temp = new int[target+1];
			for(int i = 0; i < counts.length; i++) 
				temp[i] = counts[i];
			counts = temp;
		}
		//如果当前层数的方法数已知，则返回当前层数的覆盖方法数
		if(counts[target] != 0) return counts[target];
		//如果当前层数的方法数未知，则需要计算
		counts[target] = RectCover(target-1)+RectCover(target-2);
		return counts[target];
    }
	
	/*
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_10 solution = new SolutionFor_10();
		for(int i = 0; i < 12; i++) {
			System.out.println(i+" 层高：" +solution.RectCover(i)+" 种覆盖法");
		}
	}
}
