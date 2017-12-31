package array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class SolutionFor_19 {
	/*
	 * 思路：
	 * 
	 */
	public ArrayList<Integer> printMatrix(int [][] matrix){
		//返回结果
		ArrayList<Integer> res = new ArrayList<Integer>();
		//行数
		int rows = matrix.length;
		//列数
		int cols = matrix[0].length;
		//行下标
		int i = 0;
		//列下标
		int j = 0;
		while(cols > 0 && rows > 0) {
			if(cols > 0 && rows >0){
				for(int k = 0; k < cols; k++) {
					res.add(matrix[i][j++]);
				}
				j--;
				rows--;
			}
			if(cols > 0 && rows >0){
				for(int k = 0; k < rows; k++)
					res.add(matrix[++i][j]);
				cols--;
			}
			if(cols > 0 && rows >0){
				for(int k = 0; k < cols; k++)
					res.add(matrix[i][--j]);
				rows--;
			}
			if(cols > 0 && rows >0){
				for(int k = 0; k < rows; k++) 
					res.add(matrix[--i][j]);
				cols--;
				j++;
			}
		}
		return res;
	}
//	public ArrayList<Integer> printMatrix(int [][] matrix) {
//		//矩阵的宽度
//		int row = matrix.length;
//		//矩阵的高度
//		//用于返回的arraylist
//		ArrayList<Integer> res = new ArrayList<Integer>();
//		int i = 0, j = 0;
////		//添加第一行
////		for(int k = 0; k < row; k++) {
////			res.add(matrix[i][j++]);
////		}
////		j--;
////		//添加最后一列
////		for(int k = 0; k < row-1; k++) {
////			res.add(matrix[++i][j]);
////		}
////		//添加最后一行
////		for(int k = 0; k < row-1; k++) {
////			res.add(matrix[i][--j]);
////		}
////		//添加第一列
////		for(int k = 0; k < row-2; k++) {
////			res.add(matrix[--i][j]);
////		}
//		//--------------------------------------------
//		
////		int m = 0;
////		for(int l = row; l > 0; l-=2){
////			//添加第一行
////			for(int k = m; k < l; k++) {
////				res.add(matrix[i][j++]);
////			}
////			j--;
////			//添加最后一列
////			for(int k = m; k < l-1; k++) {
////				res.add(matrix[++i][j]);
////			}
////			//添加最后一行
////			for(int k = m; k < l-1; k++) {
////				res.add(matrix[i][--j]);
////			}
////			//添加第一列
////			for(int k = m; k < l-2; k++) {
////				res.add(matrix[--i][j]);
////			}
////			m++;
////		}
//		//----------------------------------------------
////		right(res, matrix, 0, 0, row);
////		down(res, matrix, 1, 3, row-1);
////		left(res, matrix, 3, 2, row-1);
////		up(res, matrix, 2, 0, row-2);
//		
//		
//		int col = matrix[0].length;
////		right(res, matrix, i, j, col);
////		down(res, matrix, i+1, j+col-1, row-1);
////		left(res, matrix, i+row-1, j+col-2, col-1);
////		up(res, matrix, i+row-2, j, row-2);
//		
//		
////		while(row>0){
////			right(res, matrix, i, j, row);
////			down(res, matrix, i+1, j+row-1, row-1);
////			left(res, matrix, i+row-1, j+row-2, row-1);
////			up(res, matrix, i+row-2, j, row-2);
////			i++;
////			j++;
////			row-=2;
////		}
//		
//		while(row>0 && col>0){
//			right(res, matrix, i, j, col);
//			down(res, matrix, i+1, j+col-1, row-1);
//			left(res, matrix, i+row-1, j+col-2, col-1);
//			up(res, matrix, i+row-2, j, row-2);
//			i++;
//			j++;
//			row-=2;
//			col-=2;
//		}
//		return res;
//    }
//	
	private void up(ArrayList<Integer> res, int[][] matrix, int i, int j, int t) {
		for(int k = 0; k < t; k++)
			res.add(matrix[i--][j]);
	}
	private void down(ArrayList<Integer> res, int[][] matrix, int i, int j, int t) {
		for(int k = 0; k < t; k++)
			res.add(matrix[i++][j]);
	}
	private void right(ArrayList<Integer> res, int[][] matrix, int i, int j, int t) {
		for(int k = 0; k < t; k++)
			res.add(matrix[i][j++]);
	}
	private void left(ArrayList<Integer> res, int[][] matrix, int i, int j, int t) {
		for(int k = 0; k < t; k++)
			res.add(matrix[i][j--]);
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[][] a1 = {{1}};
		int[][] a2 = {
				{1, 2},
				{3, 4}
		};
		int[][] a3 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[][] a4 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		int[][] a5 = {
				{1},
				{2},
				{3}, 
				{4},
				{5}
		};
		
		SolutionFor_19 solution = new SolutionFor_19();
		System.out.println(solution.printMatrix(a5));
	}
}
