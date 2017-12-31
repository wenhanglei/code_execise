package tree;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class SolutionFor_18 {
	/*
	 * 思路：
	 * 递归
	 */
	public void Mirror(TreeNode root) {
        iter(root);
    }
	
	private void iter(TreeNode node) {
		if(node == null) return;
		exch(node);
		iter(node.left);
		iter(node.right);
	}
	
	/**
	 * 交换一个结点的左右子树
	 */
	private void exch(TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.left = temp;
	}
}
