package tree;

public class TreeUtils {
	
	private static TreeLinkNode node;
	
	/**
	 * 从树中获取值为i的结点
	 * @param pHead
	 * @param i
	 * @return
	 */
	public static TreeLinkNode getNode(TreeLinkNode n, int value){
		recursion(n, value);
		return node;
	}
	private static void recursion(TreeLinkNode n, int value){
		if(n == null) return;
		getNode(n.left, value);
		if(n.val == value){
			node = n;
		}
		getNode(n.right, value);
	}
	
	/**
	 * 通过一个数组获得一个生成的数
	 * @param arr
	 * @return
	 */
	public static TreeLinkNode getTree(int[] arr){
		//检查边界
		if(arr == null || arr.length == 0) return null;
		return getNode(null, arr, 0);
	}
	
	private static TreeLinkNode getNode(TreeLinkNode parent, int[] arr, int i){
		int index = i+1;
		if(i >= arr.length) return null;
		TreeLinkNode node = null;
		if(arr[i] != '#'){
			node = new TreeLinkNode(arr[i]);
			node.next = parent;
			node.left = getNode(node, arr, index*2-1);
			node.right = getNode(node, arr, index*2);
		}
		return node;
	}
	
	
}
