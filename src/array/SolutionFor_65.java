package array;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 * 矩阵中包含一条字符串"bcced"的路径， 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * 
 * @author wenhanglei
 */
public class SolutionFor_65 {
	
	private boolean[] marked;
	private boolean hasPath;
	
	/*
	 * 思路： 回溯法
	 * 深度优先遍历
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix == null || str == null) return false;
		marked = new boolean[matrix.length];
		for(int i = 0; i < matrix.length; i++){
			if(!hasPath)
				dfs(matrix, rows, cols, i, str, 0);
		}
		return hasPath;
	}

	private void dfs(char[] matrix, int rows, int cols, int v, char[] str, int i){
		marked[v] = true;
		if(i == str.length-1 && matrix[v] == str[i]) {
			hasPath = true;
			return;
		}
		if(i > 0 && matrix[v] != str[i]) {
			marked[v] = false;
			return;
		}
		if(i < str.length-1 && matrix[v] == str[i]) i++;
		
		int row = v / cols;
		int col = v % cols;
		
		//左边有值则向左遍历
		if(0 <= col-1 && hasPath == false){
			int left = row*cols + col-1;
			if(!marked[left])
				dfs(matrix, rows, cols, left, str, i);
		}
		
		//右边有值则向右遍历
		if(col+1 < cols && hasPath == false){
			int right = row*cols + col+1;
			if(!marked[right])
				dfs(matrix, rows, cols, right, str, i);
		}
		
		//上边有值则向上遍历
		if(0 <= row-1 && hasPath == false){
			int up = (row-1)*cols + col;
			if(!marked[up])
				dfs(matrix, rows, cols, up, str, i);
		}
		
		//下边有值则向下遍历
		if(row+1 < rows && hasPath== false){
			int down = (row+1)*cols + col;
			if(!marked[down])
				dfs(matrix, rows, cols, down, str, i);
		}
		marked[v] = false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		char[] matrix = { 'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd',
				'e', 'e' };
		SolutionFor_65 sol = new SolutionFor_65();
		boolean hasPath = sol.hasPath(matrix, 3, 4, "abcb".toCharArray());
		System.out.println(hasPath);
	}
}
