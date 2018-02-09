package linklist;


/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * @author wenhanglei
 */
public class SolutionFor_55 {
	public ListNode EntryNodeOfLoop(ListNode pHead){
		//判断边界条件
		if(pHead == null || pHead.next == null) return null;
		ListNode slow = pHead, fast = pHead;
		while(slow != null && fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				fast = pHead;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
    }
}
