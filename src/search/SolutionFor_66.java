package search;

import java.util.Arrays;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author wenhanglei
 */
public class SolutionFor_66 {
	
	/*
	 * 思路：
	 * 回溯法
	 */
	
	private int count;
	private boolean[][] marked;
	
	public int movingCount(int threshold, int rows, int cols){
		marked = new boolean[rows][cols];
        move(threshold, rows, cols, 0, 0);
        return count;
    }
	
	private void move(int threshold, int rows, int cols, int i, int j){
		if(i < 0 || i > rows-1 || j < 0 || j > cols-1 || marked[i][j]) return;
		marked[i][j] = true;
		int num = add(i, j);
		if(num > threshold) return;
		//向上
		move(threshold, rows, cols, i-1, j);
		//向下
		move(threshold, rows, cols, i+1, j);
		//向左
		move(threshold, rows, cols, i, j-1);
		//向右
		move(threshold, rows, cols, i, j+1);
		count++;
	}
	
	private int add(int i, int j){
		if(i == 0 && j == 0) return 0;
		int ret = i%10 + j%10;
		return ret + add(i/10, j/10);
	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		
		SolutionFor_66 sol = new SolutionFor_66();
		int movingCount = sol.movingCount(10, 1, 100);
		System.out.println(movingCount);
	}
}
