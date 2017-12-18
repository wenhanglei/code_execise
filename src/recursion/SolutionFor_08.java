package recursion;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class SolutionFor_08 {
	//record的小标表示几级台阶，该下标的值表示有几种跳法,即跳法计数器数组
	private int[] counts;
	/*
	 * 思路：
	 * 递归加循环
	 * 如果上一次跳了一个台阶则下一次需要跳剩下的target-1个台阶
	 * 如果上一次跳了两个台阶则下一个需要跳剩下的target-2个体台阶
	 * 类似于二叉树的遍历
	 */
	public int JumpFloor(int target) {
//		//如果没有台阶则返回0
//		if(target == 0) return 0;
//		//如果只有一级台阶则返回1
//		if(target == 1) return 1;
		//两句可以整合成一句
		//此时青蛙已经走到了
		if(target <= 2) return target;
		//如果record没有初始化则初始化
		if(counts == null) {
			counts = new int[target+1];
			counts[0] = 0;
			counts[1] = 1;
			counts[2] = 2;
		}
		//如果当前跳法计数器的长度不足以计算当前级数，则扩容当前跳法计数器
		if(target>=counts.length){
			int[] temp = new int[target+1];
			for(int i = 0; i < counts.length; i++) 
				temp[i] = counts[i];
			counts = temp;
		}
		if(counts[target]!=0) return counts[target];
		//当某一次的台阶级数未知的时候我们就需要计算了
		//如果跳一级，则剩下a种跳法
		int a = JumpFloor(target-1);
		//如果跳二级，则剩下b种跳法
		int b = JumpFloor(target-2);
		//设置当前级数有a+b种跳法
		counts[target] = a+b;
		//返回当前的跳法数
		return counts[target];
    }
	
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		SolutionFor_08 solution = new SolutionFor_08();
		System.out.println(solution.JumpFloor(num1));
		System.out.println(solution.JumpFloor(num2));
		System.out.println(solution.JumpFloor(num3));
		System.out.println(solution.JumpFloor(num4));
		System.out.println(solution.JumpFloor(num5));
	}
}
