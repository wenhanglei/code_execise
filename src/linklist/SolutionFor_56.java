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
		ListNode curr = pHead;
		while(curr.next != null && curr.next.val == curr.val){
			while(curr.next != null && curr.next.val == curr.val){
				curr = curr.next;
			}
			if(curr.next == null) return null;
			else {
				curr = curr.next;
				pHead = curr;
			}
		}
		if(curr.next == null) return pHead;
		while(curr.next != null){
			ListNode pf = curr.next;
			ListNode ps = curr.next.next;
			if(ps != null){
				if(pf.val != ps.val){
					curr = pf;
				}else{
					while(ps != null && pf.val == ps.val){
						ps = ps.next;
					}
					curr.next = ps;
				}
			}else{
				curr = pf;
			}
		}
		return pHead;
    }
	
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 4};
		int[] arr2 = {1, 1, 1, 3};
		int[] arr3 = {1, 2, 3, 3, 4, 4, 5};
		ListNode head = LinkListUtils.getLinkList(arr2);
		
		SolutionFor_56 sol = new SolutionFor_56();
		System.out.println(sol.deleteDuplication(head));
	}
}
