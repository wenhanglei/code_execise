package tree;

import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author wenhanglei
 */
public class SolutionFor_58 {
	
	private Stack<TreeNode> stack;
	private TreeNode root;
	private boolean isSym = true;
	private boolean push = true;
	
	boolean isSymmetrical(TreeNode pRoot){
		root = pRoot;
		stack = new Stack<TreeNode>();
		recursion(pRoot);
		if(stack.isEmpty())
			return isSym;
		else return false;
    }
	
	private void recursion(TreeNode node){
		if(node == null) return;
		recursion(node.left);
		if(!stack.isEmpty() && node == root) push = false;
		if(push){
			stack.push(node);
		}else if(node != root){
			if(!stack.isEmpty() && node.val != stack.pop().val) isSym = false;
		}
		recursion(node.right);
	}
	
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1};
		TreeNode pRoot = TreeUtils.getNodeTree(arr);
		SolutionFor_58 sol = new SolutionFor_58();
		boolean symmetrical = sol.isSymmetrical(pRoot);
		System.out.println(symmetrical);
	}
}
