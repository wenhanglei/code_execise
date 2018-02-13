package tree;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author wenhanglei
 */
public class SolutionFor_57 {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode == null) return null;
		
        return null;
    }
	
	private TreeLinkNode midOrder(TreeLinkNode node){
		return null;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {2, 3, '#', 6, 8, '#'};
		TreeLinkNode node = TreeUtils.getTree(arr);
	}
}
