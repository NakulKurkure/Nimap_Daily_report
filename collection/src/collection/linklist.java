package collection;

import java.util.Iterator;
import java.util.LinkedList;

public class linklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList <String> s=new LinkedList<>();
		s.add("Manish");
		s.add("Shahan");
		s.add("Manish");
		s.add("Saurabh");
		
		System.out.print(s+"\n");
		
//		Iterator<String> i=s.iterator();
//		while(i.hasNext())//check element
//		{
//			System.out.print(i.next()+"\n");
//		}
//		
//		for(String t:s)
//		{
//			System.out.print(t);
//		}
		
		LinkedList <String> s1=new LinkedList<>();
		s1.add("rock");
		s1.add("john");
		s1.add("rko");
		s1.add("hhh");
		
		s.addAll(s1);
		System.out.print(s+"\n");
		
		s.set(1, "mayur");
		System.out.print(s+"\n");
		
		System.out.print(s.remove(6)+"\n");
		System.out.print(s+"\n");
		
		System.out.print(s.get(4)+"\n");
		
		System.out.print(s.indexOf("rock")+"\n");
		
		s.addFirst("brock");
		System.out.print(s+"\n");
		
		s.addLast("dean");
		System.out.print(s);
		
		
		
		
		
	}

}
