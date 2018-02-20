package tree;
/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * @author wenhanglei
 */
public class SolutionFor_62 {
	
	private TreeNode res;
	private int count;
	private int k;
	
	/*
	 * 思路：
	 * 中序遍历
	 */
	TreeNode KthNode(TreeNode pRoot, int k){
		if(pRoot == null || k <= 0) return null;
		count = 1;
		this.k = k;
		midOrder(pRoot);
        return res;
    }
	
	private void midOrder(TreeNode node){
		if(node == null) return;
		midOrder(node.left);
		if(count != k)
			count++;
		else if(count == k)
			res = node;
		midOrder(node.right);
	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 2, 4, 6, 8};
		TreeNode root = TreeUtils.getNodeTree(arr);
		
		SolutionFor_62 sol = new SolutionFor_62();
		TreeNode kthNode = sol.KthNode(root, 3);
		System.out.println(kthNode.val);
	}
}
