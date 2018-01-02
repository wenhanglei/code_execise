package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class SolutionFor_22 {
	/*
	 * 思路：
	 * 层序遍历
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if(root == null) return null;
        //返回结果
		ArrayList<Integer> res = new ArrayList<Integer>();
		//层序遍历的队列
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode node = q.remove();
			if(node != null)
				res.add(node.val);
			if(node.left != null) q.offer(node.left);
			if(node.right != null) q.offer(node.right);
		}
		return res;
    }
	
}
