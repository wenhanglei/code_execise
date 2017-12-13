package linklist;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class SolutionFor_03 {
	/*
	 * 思路：
	 * 利用递归的栈特性完成数据的添加
	 */
	public ArrayList<Integer> printListFromTailtoHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		addInt(result, listNode);
		return result;
	}
	private void addInt(ArrayList<Integer> result, ListNode listNode) {
		if(listNode == null) return;
		addInt(result, listNode.next);
		result.add(listNode.val);
	}
//	public ArrayList<Integer> printListFromTailtoHead(ListNode listNode) {
//		//辅助用的链表作用类似与栈
//		ArrayList<Integer> ass = new ArrayList<Integer>();
//		//用于存储结果的链表
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		while(listNode != null){
//			ass.add(listNode.val);
//			listNode = listNode.next;
//		}
//		while(!ass.isEmpty())
//			result.add(ass.remove(ass.size()-1));
//		return result;
//	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		SolutionFor_03 so = new SolutionFor_03();
		for(int i : so.printListFromTailtoHead(l1))
			System.out.println(i);
	}
}

class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
