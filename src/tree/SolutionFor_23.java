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
		if(sequence.length == 1) return true;
		else 
			return verifySquenceOfBST(sequence, 0, sequence.length-1);
    }
	/**
	 * 求当前子树的左右子树分割值
	 */
	private int partition(int[] sequence, int lo, int hi){
		for(int i = hi-1; i >= lo; i--){
			if(sequence[i] < sequence[hi])
				return i;
		}
		return lo;
	}
	
	private boolean verifySquenceOfBST(int[] sequence, int lo, int hi) {
		int max = lo;
		int min = lo;
		if(sequence[hi] > sequence[hi-1]){
			for(int i = hi-2; i >= lo; i--) {
				if(sequence[i] > sequence[hi]){
					min = hi-1;
					max = i;
					break;
				}
			}
		}else if(sequence[hi] < sequence[hi-1]){
			for(int i = hi-2; i >= lo; i--) {
				if(sequence[i] < sequence[i]){
					max = hi-1;
					min = i;
					break;
				}
			}
		}
		if(max < min) return false;
		else if(max == min) return true;
		else{
			int mid = partition(sequence, lo, hi);
			return verifySquenceOfBST(sequence, lo, mid-1) && verifySquenceOfBST(sequence, mid, hi-1);
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
		SolutionFor_23 solution = new SolutionFor_23();
		System.out.println(solution.VerifySquenceOfBST(seq3));
	}
}
