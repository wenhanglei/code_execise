package tree;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author wenhanglei
 */
public class SolutionFor_61 {
	/*
	 * 思路：
	 * 知道了前序和中序遍历可恢复二叉树
	 */
	
	String Serialize(TreeNode root) {
		if(root == null) return null;
		StringBuilder sb = new StringBuilder();
		pre(root, sb);
		sb.deleteCharAt(sb.length()-1);
		sb.append("#");
		mid(root, sb);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	private void pre(TreeNode node, StringBuilder sb){
		if(node == null) return;
		sb.append(node.val + ",");
		pre(node.left, sb);
		pre(node.right, sb);
	}
	
	private void mid(TreeNode node, StringBuilder sb){
		if(node == null) return;
		mid(node.left, sb);
		sb.append(node.val + ",");
		mid(node.right, sb);
	}
	
	TreeNode Deserialize(String str) {
		if(str == null) return null;
		String[] strs = str.split("#");
		String[] arr1 = strs[0].split(",");
		String[] arr2 = strs[1].split(",");
		
		int[] pre = new int[arr1.length];
		int[] in = new int[arr2.length];
		
		for(int i = 0; i < arr1.length; i++){
			pre[i] = Integer.parseInt(arr1[i]);
			in[i] = Integer.parseInt(arr2[i]);
		}
		
		return visit(pre, in, 0, in.length, 0);
	}
	
	private TreeNode visit(int[] pre, int[] in, int lo, int hi, int currIndex) {
    	if(lo >= hi) return null;
    	//用于返回的节点变量
    	TreeNode node = null;
    	//该节点左子树的节点个数
    	int leftNum = 0;
    	//中序分割值
    	int sep = lo;
    	node = new TreeNode(pre[currIndex]);
    	while(pre[currIndex] != in[sep]){
    		sep++;
    		leftNum++;
    	}
    	//添加左子树
    	node.left = visit(pre, in, lo, sep, currIndex+1);
    	//添加右子树
    	node.right = visit(pre, in, sep+1, hi, currIndex+leftNum+1);
    	return node;
    }
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = TreeUtils.getNodeTree(arr);
		SolutionFor_61 sol = new SolutionFor_61();
		String str = sol.Serialize(root);
		System.out.println(str);
		TreeNode node = sol.Deserialize(str);
		System.out.println(sol.Serialize(node));
	}
}
