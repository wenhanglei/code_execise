package tree;

import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class SolutionFor_23 {
	/*
	 * 思路：
	 * 后序遍历序列从后向前遍历
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0) return false;
		else return verifySquenceOfBST(sequence, 0, sequence.length-1);
    }
	
	private boolean verifySquenceOfBST(int[] sequence, int lo, int hi) {
		if(hi <= lo+1) return true;
		//如果只有左子树
		if(sequence[hi] > sequence[hi-1]){
			for(int i = hi-2; i >= 0; i--) {
				if(sequence[i] > sequence[hi])
					return false;
			}
			return verifySquenceOfBST(sequence, lo, hi-1);
		}else{
			//保存最小值的下标
			int min = lo-1;
			for(int i = hi-2; i >= 0; i--) {
				if(sequence[i] < sequence[hi]){
					min = i;
					break;
				}
			}
			for(int i = min; i >= 0; i--) {
				if(sequence[i] > sequence[hi]){
					return false;
				}
			}
			if(min == lo-1) {
				return verifySquenceOfBST(sequence, lo, hi-1);
			}else {
				return verifySquenceOfBST(sequence, lo, min) &&
						verifySquenceOfBST(sequence, min+1, hi-1);
			}
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] seq = {2, 5, 4, 9, 12, 10, 8};
		int[] seq1 = {2, 5, 4};
		int[] seq2 = {7, 2, 5, 6};
		int[] seq3 = {7, 4, 6, 5};
		int[] seq4 = {5, 4, 3, 2, 1};
		int[] seq5 = {4, 6, 7, 5};
		SolutionFor_23 solution = new SolutionFor_23();
		System.out.println(solution.VerifySquenceOfBST(seq2));
	}
}
