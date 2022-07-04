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
		
//		System.out.print(l);
		
		//Traversing List
//		Iterator itr=l.iterator();
//		
//			while(itr.hasNext())//check if iterator has the elements  
//			{
//				System.out.println(itr.next());//printing the element and move to next 
//			}
		
		//for-each loop
		for(int i:l)
		{
			System.out.println(i);
		}
		
		
	}

}
