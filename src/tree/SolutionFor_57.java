package tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author wenhanglei
 */
public class SolutionFor_57 {
	
	/*
	 * 思路：
	 * 右子树的的最左边的结点
	 * 当没有右子树的时候是第一个右父节点
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode == null) return null;
		TreeLinkNode curr = null;
		//检查右子树是否为null
		if(pNode.right != null){
			curr = pNode.right;
			while(curr.left != null){
				curr = curr.left;
			}
			if(curr != null) return curr;
		}
		//当没有右子树的时候返回第一个右父节点
		curr = pNode;
		while(curr.next != null && curr.next.right == curr){
			curr = curr.next;
		}
		if(curr.next == null) return null;
		return curr.next;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {2, 3, '#', 6, 8, '#'};
		TreeLinkNode node = TreeUtils.getTree(arr);
		TreeLinkNode n = TreeUtils.getNode(node, 2);
		SolutionFor_57 sol = new SolutionFor_57();
		System.out.println(sol.GetNext(n));
	}
}
