package linklist;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class SolutionFor_25 {
	/*
	 * 思路： 遍历整个链表关联数组下标 创建
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null) return null;
		//用于返回的头结点
		RandomListNode resHead = new RandomListNode(pHead.label);
		// 用于关联数组下标的map
		HashMap<RandomListNode, Integer> map = new HashMap<RandomListNode, Integer>();
		RandomListNode curr = pHead;
		int num = 0;
		while (curr != null) {
			map.put(curr, num++);
			curr = curr.next;
		}
		//创建结点数组
		RandomListNode[] nodeArray = new RandomListNode[num];
		//保存头结点
		nodeArray[0] = resHead;
		curr = pHead;
		//用于放回的头结点
		while(curr != null) {
			int index = map.get(curr);
			//如果当前结点还未创建，创建之
			if(nodeArray[index] == null)
				nodeArray[index] = new RandomListNode(curr.label);
			//如果下一个结点未创建，创建之
			if(curr.next != null) {
				int next = map.get(curr.next);
				if(nodeArray[next] == null) 
					nodeArray[next] = new RandomListNode(curr.next.label);
				//关联下一个结点
				nodeArray[index].next = nodeArray[next];
			}
			if(curr.random != null) {
				//如果随机结点未创建，创建之
				int rand = map.get(curr.random);
				if(rand <= num && nodeArray[rand] == null)
					nodeArray[rand] = new RandomListNode(curr.random.label);
				//关联随机结点
				nodeArray[index].random = nodeArray[rand];
			}
			curr = curr.next;
		}
		return resHead;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(2);
		RandomListNode node2 = new RandomListNode(3);
		node1.next = node2;
		
		SolutionFor_25 solution = new SolutionFor_25();
		RandomListNode newNode = solution.Clone(node1);
	}

}
