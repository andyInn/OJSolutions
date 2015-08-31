package leetcodeOJ;

import java.util.Stack;

public class _232ImplementQueueUsingStacks {

	public Stack<Integer> s1;
	public Stack<Integer> s2;
	
	public _232ImplementQueueUsingStacks(){
		s1=new Stack<Integer>();
		s2=new Stack<Integer>();
	}
	
	// Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.empty()){
        	s2.push(s1.pop());
        }
        s2.pop();
        while(!s2.empty()){
        	s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	while(!s1.empty()){
        	s2.push(s1.pop());
        }
        int res=s2.peek();
        while(!s2.empty()){
        	s1.push(s2.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty();
    }
    
    public static void main(String ...strings){
    	_232ImplementQueueUsingStacks o=new _232ImplementQueueUsingStacks();
    	o.push(1);
    	o.push(2);
    	System.out.println(o.empty());
    	System.out.println(o.peek());
    	o.pop();
    	System.out.println(o.peek());
    }
}
