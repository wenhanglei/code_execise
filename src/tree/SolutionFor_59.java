package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树， 即第一行按照从左到右的顺序打印， 第二层按照从右至左的顺序打印， 第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author wenhanglei
 */
public class SolutionFor_59 {

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		// 结果变量
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return res;
		//当前遍历的层数
		int level = 1; 
		//stack1存储奇数层
		Stack<TreeNode> stack1 = new Stack<>();
		//stack2存储偶数层
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(pRoot);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			ArrayList<Integer> list = new ArrayList<>();
			//如果当前层为奇数层
			if(level % 2 != 0){
				while(!stack1.isEmpty()){
					TreeNode node = stack1.pop();
					list.add(node.val);
					if(node.left != null)
						stack2.push(node.left);
					if(node.right != null)
						stack2.push(node.right);
				}
			}else{
				while(!stack2.isEmpty()){
					TreeNode node = stack2.pop();
					list.add(node.val);
					if(node.right != null)
						stack1.push(node.right);
					if(node.left != null)
						stack1.push(node.left);
				}
			}
			res.add(list);
			level++;
		}
		return res;

	}

	/**
	 * 测试函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4, 5, 6, 7 };
		TreeNode tree = TreeUtils.getNodeTree(arr);
		SolutionFor_59 sol = new SolutionFor_59();
		sol.Print(tree);
	}
}
