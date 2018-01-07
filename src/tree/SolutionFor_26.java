package tree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class SolutionFor_26 {
	/*
	 * 思路：
	 * 中序遍历线索化
	 * 根节点设定为是上一个结点的左孩子
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //结果变量
        TreeNode res = min(pRootOfTree);
        //修改指针
        search(stack, pRootOfTree);
        return res;
    }
	
	/**
	 * 中序遍历二叉树
	 * Stack是当前结点的前驱结点的容器
	 */
	private void search(Stack<TreeNode> stack, TreeNode node) {
		if(node == null) return;
		search(stack, node.left);
		//如果当前结点没有前驱结点则表示该结点是首结点
		if(!stack.isEmpty()){
			//获取前驱结点
			TreeNode pre = stack.pop();
			//修改指针指向
			pre.right = node;
			node.left = pre;
			
		}
		stack.push(node);
		search(stack, node.right);
	}
	
	/**
	 * 返回二叉树最左边的几点:
	 * 事件复杂度：O(logn)
	 */
	private TreeNode min(TreeNode node) {
		if(node.left == null) return node;
		else return min(node.left);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		SolutionFor_26 solution = new SolutionFor_26();
		TreeNode curr = solution.Convert(root);
		while(curr != null){
			System.out.println(curr.val);
			curr = curr.right;
		}
	}
}
