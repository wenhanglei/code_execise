package linklist;
/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author wenhanglei
 */
public class SolutionFor_56 {
	public ListNode deleteDuplication(ListNode pHead){
		//检查边界条件
		if(pHead == null || pHead.next == null) return pHead;
		return deleteDup(pHead);
    }
	
	private ListNode deleteDup(ListNode curr){
		if(curr == null) return null;
		ListNode next = deleteDup(curr.next);
		if(next == null) return curr;
		if(curr.val != next.val){
			curr.next = next;
			return curr;
		}else {
			return next.next;
		}
		
	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 4};
		ListNode head = LinkListUtils.getLinkList(arr);
		
		SolutionFor_56 sol = new SolutionFor_56();
		sol.deleteDuplication(head);
	}
}
