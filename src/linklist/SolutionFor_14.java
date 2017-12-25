package linklist;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class SolutionFor_14 {
	/*
	 * 思路：
	 * 1. 先遍历一次求出节点的总个数
	 * 2. 根据倒数第k项算出该节点需要遍历的次数返回该节点
	 * 
	 * 必须考虑如果总的长度小于要求的k项的情况！
	 */
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null) return null;
		//求出结点的总个数
		int total = 1;
		ListNode curr = head;
		while(curr.next != null){
			curr = curr.next;
			total++;
		}
		
		//重点！！！！！！！！！！！！！！！！！！！
		if(total < k) return null;
		
		curr = head;
		for(int i = 0; i < total-k; i++){
			curr = curr.next;
		}
		return curr;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		SolutionFor_14 solution = new SolutionFor_14();
		System.out.println(solution.FindKthToTail(n1, 1).val);
		System.out.println(solution.FindKthToTail(n1, 2).val);
		System.out.println(solution.FindKthToTail(n1, 3).val);
	}
}

