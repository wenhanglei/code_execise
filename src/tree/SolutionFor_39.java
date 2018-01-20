package tree;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class SolutionFor_39 {
	boolean isBalanced = true;
	/*
	 * 思路：
	 * 递归
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
        IsBalancedTree(root);
        return isBalanced;
    }
	
	/**
	 * 遍历当前树返回以当前结点为根节点的树的高度
	 */
	private int IsBalancedTree(TreeNode node){
		//边界条件判断
		if(node == null) return 0;
		int left = IsBalancedTree(node.left);
		int right = IsBalancedTree(node.right);
		if(Math.abs(left-right) > 1) isBalanced = false;
		return Math.max(left, right)+1;
	}
}
