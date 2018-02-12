package tree;

public class TreeUtils {
	
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
