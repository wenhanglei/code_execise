package tree;

import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author wenhanglei
 */
public class SolutionFor_58 {
	
	boolean isSymmetrical(TreeNode pRoot){
		if(pRoot == null) return true;
		return equal(pRoot.left, pRoot.right);
    }
	
	private boolean equal(TreeNode n1, TreeNode n2){
		if(n1 == null && n2 == null) return true;
		else if(n1 != null && n2 != null){
			if(equal(n1.left, n2.right) && equal(n1.right, n2.left)){
				if(n1.val == n2.val) return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 4, '#'};
		TreeNode pRoot = TreeUtils.getNodeTree(arr);
		SolutionFor_58 sol = new SolutionFor_58();
		boolean symmetrical = sol.isSymmetrical(pRoot);
		System.out.println(symmetrical);
	}
}
