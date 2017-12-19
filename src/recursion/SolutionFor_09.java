package recursion;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class SolutionFor_09 {
	//跳法计数器数组，下标表示台阶数，对应下标的值为该台阶数可能的跳法
	private int[] counts;
	/*
	 * 思路：
	 * 递归加循环
	 */
	public int JumpFloorII(int target) {
		//如果台阶数小于等于2返回target
		if(target <= 2) return target;
		//如果跳法计数器为null，初始化跳法计数器
		if(counts == null) {
			counts = new int[target+1];
			counts[0] = 0;
			counts[1] = 1;
			counts[2] = 2;
		}
		//如果跳法计数器长度不够，则扩容
		if(counts.length <= target) {
			int[] temp = new int[target+1];
			for(int i = 0; i < counts.length; i++)
				temp[i] = counts[i];
			counts = temp;
		}
		//如果当前级数的跳法数存在则返回该跳法数
		if(counts[target] != 0) return counts[target];
		//如果当前级数的跳法数不存在则需要计算
		for(int i = 1; i < target; i++) {
			counts[target] += JumpFloorII(target-i);
		}
		//一次跳完也是一种跳法需要加一
		counts[target]++;
        return counts[target];
    }
	
	/*
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_09 solution = new SolutionFor_09();
		for(int i = 0; i < 11; i++){
			System.out.println(i+" 级台阶：" +solution.JumpFloorII(i)+" 种跳法");
		}
	}
}
