package string;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author wenhanglei
 */
public class SolutionFor_54 {
	//list记录所有的出现一次的字符
	private LinkedList<Character> list;
	//使用HashMap保存每个字符出现的次数
	private HashMap<Character, Integer> map;
	/*
	 * 思路：
	 * 使用linkedlist保存所有第一个出现的字符
	 * 	
	 */
	//Insert one char from stringstream
    public void Insert(char ch){
    	if(list == null)
    		list = new LinkedList<Character>();
    	if(map == null)
    		map = new HashMap<Character, Integer>();
    	if(!map.containsKey(ch)){
    		list.add(ch);
    		map.put(ch, 1);
    	}else{
    		map.put(ch, map.get(ch)+1);
    		if(list.contains(ch))
    			list.remove(list.indexOf(ch));
    	}
    	
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	if(list == null || list.isEmpty()) return '#';
    	else return list.getFirst();
    }
    
    /**
     * 测试函数
     */
    public static void main(String[] args) {
		SolutionFor_54 sol = new SolutionFor_54();
		sol.Insert('g');
		sol.Insert('o');
		sol.Insert('o');
		sol.Insert('g');
		sol.Insert('l');
		sol.Insert('e');
		System.out.println(sol.FirstAppearingOnce());
	}
}
