package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author wenhanglei
 */
public class SolutionFor_60 {
	/*
	 * 思路：
	 * 层序遍历
	 */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	//结果变量
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	if(pRoot == null) return res;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	ArrayList<Integer> list = new ArrayList<>();
    	queue.offer(pRoot);
    	queue.offer(null);
    	while(!queue.isEmpty()){
    		TreeNode curr = queue.poll();
    		if(curr == null) continue;
    		list.add(curr.val);
    		if(curr.left != null) queue.offer(curr.left);
    		if(curr.right != null) queue.offer(curr.right);
    		if(queue.peek() == null){
    			res.add(list);
    			list = new ArrayList<>();
    			queue.offer(null);
    		}
    	}
    	return res;
    }
    
    
    /**
     * 测试函数
     * @param args
     */
    public static void main(String[] args) {
    	int[] arr = {1, 2, 3, 4, 5, 6, 7};
    	TreeNode root = TreeUtils.getNodeTree(arr);
    	SolutionFor_60 sol = new SolutionFor_60();
    	sol.Print(root);
	}
}
