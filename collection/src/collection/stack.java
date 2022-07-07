package collection;

import java.util.Stack;

public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s=new Stack<>();
		s.push(11);
		s.push(22);
		s.push(33);
		s.push(44);
		s.push(55);
		System.out.println(s);
		
		System.out.println(s.size());//size
		
		System.out.println(s.pop());//last element remove
		System.out.println(s);
		System.out.println(s.peek());// top in the stack //44
		System.out.println(s.search(11));//starts with 1
		
		boolean r=s.empty();  
		System.out.println(r);
	}

}
