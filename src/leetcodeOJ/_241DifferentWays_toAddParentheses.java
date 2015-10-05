package leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

public class _241DifferentWays_toAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
    	if(input==null||"".equals(input)){
    		return null;
    	}
    	List<Integer> li=new ArrayList<Integer>();
        for(int i=0;i<input.length();i++){
        	char ch=input.charAt(i);
        	if(ch=='+'||ch=='-'||ch=='*'){
        		List<Integer> ll=diffWaysToCompute(input.substring(0, i));
        		List<Integer> lr=diffWaysToCompute(input.substring(i+1));
        		for(int j=0;j<ll.size();j++){
        			for(int k=0;k<lr.size();k++){
        				switch(ch){
        					case '+':li.add(ll.get(j)+lr.get(k));break;
        					case '-':li.add(ll.get(j)-lr.get(k));break;
        					case '*':li.add(ll.get(j)*lr.get(k));break;
        					default :break;
        				}
        			}
        		}
        	}
        }
        if(li.isEmpty()){
        	li.add(Integer.parseInt(input));
        }
        return li;
    }
    
    public static void main(String[] args){
    	_241DifferentWays_toAddParentheses o=new _241DifferentWays_toAddParentheses();
    	List<Integer> li=o.diffWaysToCompute("11*23-5+6");
    	System.out.println(li.toString());
    }
}