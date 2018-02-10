package linklist;

public class LinkListUtils {
	
	/**
	 * 根据数组生成相应的链表
	 */
	public static ListNode getLinkList(int[] arr){
		if(arr == null || arr.length == 0) return null;
		ListNode head = new ListNode(arr[0]);
		ListNode curr = head;
		for(int i = 1; i < arr.length; i++){
			curr.next = new ListNode(arr[i]);
			curr = curr.next;
		}
		return head;
	}
}
