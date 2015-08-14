package leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class _242ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		boolean isTrue = true;
		int lens = s.length(), lent = t.length();
		if ((s == null && t == null) || s == null || t == null || lens != lent)
			return false;
		if (s.equals(t))
			return true;
		Map<Character, Integer> m1=new HashMap<Character, Integer>();
		Map<Character, Integer> m2=new HashMap<Character, Integer>();
		char ch='a';
		int count=0;
		for(int i=0;i<lens;i++){
			ch=s.charAt(i);
			if(!m1.containsKey(ch)){
				m1.put(ch, 1);
			}else{
				count=m1.get(ch);
				m1.put(ch, ++count);
			}
			ch=t.charAt(i);
			if(!m2.containsKey(ch)){
				m2.put(ch, 1);
			}else{
				count=m2.get(ch);
				m2.put(ch, ++count);
			}
		}//for
		int len1=m1.size(),len2=m2.size();
		if(len1!=len2)
			return false;
		for(Character cht: m1.keySet()){
			if(m2.containsKey(cht)){
				if(!m1.get(cht).equals(m2.get(cht))){
					isTrue=false;
					break;
				}
			}else{
				isTrue=false;
				break;
			}
		}
		return isTrue;
	}
	
	public static void main(String[] args){
		String s="car",t="car";
		System.out.println(isAnagram(s, t));;
	}
}