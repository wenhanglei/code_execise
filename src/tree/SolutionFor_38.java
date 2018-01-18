package tree;
/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class SolutionFor_38 {
	int depth;
	/*
	 * 思路:
	 * 先序遍历
	 */
	public int TreeDepth(TreeNode root) {
        if(root == null) return depth;
        preorder(root);
        return depth;
    }
    private void preorder(TreeNode n) {
        if(n == null) return;
        preorder(n.left);
        preorder(n.right);
    }
}
