package linklist;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class SolutionFor_36 {
	/*
	 * 思路:
	 * map
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null) return null;
		 ListNode curr1 = pHead1;
		 ListNode curr2 = pHead2;
		 HashMap<ListNode, Object> map = new HashMap<ListNode, Object>();
		 while(curr1 != null) {
			 map.put(curr1, null);
			 curr1 = curr1.next;
		 }
		 while(curr2 != null){
			 if(map.containsKey(curr2))
				 return curr2;
			 curr2 = curr2.next;
		 }
		 return null;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
