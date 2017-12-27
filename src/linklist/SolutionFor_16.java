package linklist;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class SolutionFor_16 {
	public ListNode Merge(ListNode list1,ListNode list2) {
		//返回可能为null所有情况
		if(list1 == null && list2 == null) return null;
		else if(list1 == null || list2 == null) 
			return list1!=null?list1:list2;
		//用于返回的结果链表的头结点
		ListNode head;
		//用于存储当前比较结果中较小的结点
		ListNode min;
		//初始化头结点和尾结点
		if(list1.val < list2. val) {
			head = list1;
		}
		else {
			head = list2;
		}
		
		
		while(list1 != null && list2 != null){
			//判断当前两个结点谁的值更小
			if(list1.val < list2.val) { 
				min = list1;
				list1 = list1.next;
				min.next = list2;
			}
			else {
				min =list2;
				list2 = list2.next;
				min.next = list1;
				
			}
		}
		
		return head;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		ListNode list2 = new ListNode(1);
		ListNode a = list1;
		ListNode b = list2;
		for(int i = 0; i < 3; i++) {
			a.next = new ListNode(1 + a.val);
			b.next = new ListNode(1 + b.val);
			a = a.next;
			b = b.next;
		}
		ListNode aa = list1;
		ListNode bb = list2;
		while(aa != null) {
			System.out.print(aa.val + " ");
			aa = aa.next;
		}
		System.out.println();
		while(bb != null) {
			System.out.print(bb.val + " ");
			bb = bb.next;
		}
		System.out.println();
		SolutionFor_16 solution = new SolutionFor_16();
		ListNode c = solution.Merge(list1, list2);
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
	}
}
