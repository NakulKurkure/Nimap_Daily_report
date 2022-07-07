package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> l=new ArrayList<Integer>();//creating ArrayList
		l.add(123);//Adding objects
		l.add(12345);
		l.add(12456);
		l.add(12);
		
		System.out.print(l+"\n");
		
		//Traversing List
//		Iterator itr=l.iterator();
//		
//			while(itr.hasNext())//check if iterator has the elements  
//			{
//				System.out.println(itr.next());//printing the element and move to next 
//			}
		
		//for-each loop
//		for(int i:l)
//		{
//			System.out.println(i);
//		}
//		
		
		//add index to element
		l.add(1,3456);
		System.out.println(l+"\n");
		
		ArrayList<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(4);
		a.add(7);
		
		//Add One List to another
		l.addAll(a);
		System.out.print(l+"\n");
		
		l.set(1, 999);
		System.out.print(l+"\n");
		
		l.remove(5);
		System.out.print(l+"\n");
		
		
		System.out.print(l.get(2)+"\n");
		
		System.out.print(l.indexOf(12345)+"\n");
		
	
		
		
		
	}

}
