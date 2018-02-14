package tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author wenhanglei
 */
public class SolutionFor_57 {
	
	private LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
	
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode == null) return null;
		//查找根节点
		TreeLinkNode curr = pNode;
		while(curr.next != null){
			curr = curr.next;
		}
		//中序遍历根节点
		midOrder(curr);
		Iterator<TreeLinkNode> iterator = list.iterator();
		while(iterator.hasNext()){
			if(pNode == iterator.next()){
				if(iterator.hasNext())
					return iterator.next();
				else return null;
			}
		}
        return null;
    }
	
	private void midOrder(TreeLinkNode curr){
		if(curr == null) return;
		midOrder(curr.left);
		list.add(curr);
		midOrder(curr.right);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {2, 3, '#', 6, 8, '#'};
		TreeLinkNode node = TreeUtils.getTree(arr);
		TreeLinkNode n = TreeUtils.getNode(node, 6);
		SolutionFor_57 sol = new SolutionFor_57();
		System.out.println(sol.GetNext(n));
	}
}
