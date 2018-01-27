package simulation;

import java.util.ArrayList;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class SolutionFor_46 {
	
	private int index;
	/*
	 * 思路：
	 */
	public int LastRemaining_Solution(int n, int m) {
        //边界条件判定
		if(n == 0) return -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			list.add(i);
		}
		int index = (m-1)%n;
		for(int i = 0; i < n-1; i++){
			list.remove(index);
			index += m-1;
			index %= list.size();
		}
		return list.get(0);
    }
	
	
	
	/**
	 * n表示剩下的小朋友的数量
	 * 上一个处理的小标
	 * 返回下一个要处理的下标
	 */
	private int next(boolean[] arr, int curr){
		curr++;
		curr %= arr.length;
		while(arr[curr])
			curr++;
		return curr;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SolutionFor_46 solution = new SolutionFor_46();
		System.out.println(solution.LastRemaining_Solution(5, 3));
	}
}
