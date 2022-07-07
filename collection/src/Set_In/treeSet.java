package Set_In;
import java.util.*;
//import java.util.Iterator;
import java.util.TreeSet;

public class treeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<String> t=new TreeSet<String>();
		t.add("Manish");
		t.add("Harshal");
		t.add("Shahan");
		t.add("prem");
		
//		Iterator<String> i=t.iterator();
//		while(i.hasNext())
//		{
//			System.out.println(i.next());
//		}
//		
		System.out.println(t.pollFirst());//lowest value
		System.out.println(t.pollLast());//Highest value
		
	
		
//		for(String i:t)
//		{
//			System.out.println(i);
//		}
	}
	

}
