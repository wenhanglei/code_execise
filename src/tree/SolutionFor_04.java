package tree;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class SolutionFor_04 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	/*
    	 * 思路：
    	 * 使用递归把问题分解
    	 * 设计一个函数返回传递节点的子节点
    	 */
        return visit(pre, in, 0, in.length, 0);
    }
    /*
     * 辅助函数，lo表示当前遍历序列的下界，hi表示当前遍历序列大上界 ，当前需要创建的节点的值的下标
     */
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
    
    public static void main(String[] args) {
		int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};
		
		SolutionFor_04 solution = new SolutionFor_04();
		TreeNode root = solution.reConstructBinaryTree(preOrder, midOrder);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
