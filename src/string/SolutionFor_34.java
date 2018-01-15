package string;

import java.util.HashMap;


/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class SolutionFor_34 {
	/*
	 * 思路：
	 * 使用hashmap
	 */
	public int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() < 1) return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))){
				Integer t = map.get(str.charAt(i));
				map.put(str.charAt(i), ++t);
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		int pos = -1;
		for(int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i)) == 1)
				return i;
		}
        return pos;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
