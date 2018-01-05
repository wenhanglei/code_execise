package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class SolutionFor_24 {
	
	//二叉树遍历当前路径的数值和
	private int sum;
	private Stack<Integer> stack;
	
	
	/*
	 * 思路： 先序遍历整个二叉树，如果累积的结点和等于target则返回结点值list
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		// 返回结果
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		stack = new Stack<Integer>();
		//初始化路径和
		sum = 0;
		search(res, root, target);
		return res;
	}

	/**
	 * 结点遍历函数
	 */
	private void search(ArrayList<ArrayList<Integer>> res, TreeNode node, int target) {
		if(node == null) return;
		// 当前结点入栈
		stack.push(node.val);
		// 修改当前路径的数值和
		sum += node.val;
		// 判断当前结点是否是叶子结点
		// 如果是叶子结点
		if (node.right == null && node.left == null) {
			// 判断是否当前路径数值和是否与目标值相等
			// 如果相等，表示该路径是一条所求路径
			if (sum == target) {
				//创建路径链表
				ArrayList<Integer> path = new ArrayList<Integer>(stack);
				//将链表添加到结果集中
				res.add(path);
			}
			//当前数值出栈
			sum -= stack.pop();
		} else { // 如果不是叶子结点
			//如果当前数值和大于等于目标值
			if(sum >= target){
				//当前结点出栈
				stack.pop();
				return;
			}
			search(res, node.left, target);
			search(res, node.right, target);
			sum -= stack.pop();
		}
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(12);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		SolutionFor_24 solution = new SolutionFor_24();
		
		System.out.println(solution.FindPath(node1, 22));

	}
}
