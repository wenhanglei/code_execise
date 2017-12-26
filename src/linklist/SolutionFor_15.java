package linklist;
/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class SolutionFor_15 {
	/*
	 * 思路：
	 * 
	 */
	public ListNode ReverseList(ListNode head) {
		//如果传递的链表为空 则返回null
		if(head == null) return null;
		//遍历链表修改链表的指向
		ListNode curr = head;
		ListNode next = curr.next;
		if(next == null) return curr;
		curr.next = null;
		ListNode temp = curr;
		curr = next;
		while(curr != null) {
			next = curr.next;
			curr.next = temp;
			if(next == null) break;
			temp = curr;
			curr = next;
		}
		return curr;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;
//		for(int i = 2; i <= 10; i++) {
//			curr.next = new ListNode(i);
//			curr = curr.next;
//		}
		
		SolutionFor_15 solution = new SolutionFor_15();
		ListNode node = solution.ReverseList(head);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
