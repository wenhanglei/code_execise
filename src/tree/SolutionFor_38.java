package tree;
/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class SolutionFor_38 {
	int maxDepth;
	/*
	 * 思路:
	 * 先序遍历
	 */
	public int TreeDepth(TreeNode root) {
        if(root == null) return maxDepth;
        preorder(root, 0);
        return maxDepth;
    }
    private void preorder(TreeNode n, int depth) {
        if(n == null) return;
        if(depth > maxDepth) maxDepth = depth;
        preorder(n.left, depth+1);
        preorder(n.right, depth+1);
    }
}
