package tree;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SolutionFor_17 {
	/*
	 * 思路：
	 * 写完自己都看不懂了
	 */
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1 != null && root2 != null){
			if(isEqual(root1, root2))
				return true;
			else if(HasSubtree(root1.left, root2))
				return true;
			else if(HasSubtree(root1.right, root2))
				return true;
			return false;
		}else return false;
    }
	
	
	private boolean isEqual(TreeNode a, TreeNode b) {
		if(b == null) return true;
		else if(a != null && b != null){
			if(a.val != b.val ) return false;
			else if(isEqual(a.left, b.left) && isEqual(a.right, b.right)){
				return true;
			}else
				return false;
		}else return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
		
	}
}
