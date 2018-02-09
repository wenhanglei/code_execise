package linklist;

import java.util.HashMap;
import java.util.Map;


/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * @author wenhanglei
 */
public class SolutionFor_55 {
	public ListNode EntryNodeOfLoop(ListNode pHead){
		if(pHead == null) return null;
        Map<ListNode, Object> map = new HashMap<ListNode, Object>();
        ListNode curr = pHead;
        while(curr != null){
        	if(map.containsKey(curr)) return curr;
        	map.put(curr, null);
        	curr = curr.next;
        }
        return null;
    }
}
