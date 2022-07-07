package Set_In;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Linked_HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Don't allow duplicate values
		
		LinkedHashSet<String> l=new LinkedHashSet<>();
		l.add("The Rock");
		l.add("john Cena");
		l.add("Brock");
		l.add("Brock");
		l.add("Roman");
		l.add("null");
		
		//Ignore duplicate Element..
		Iterator<String> s=l.iterator();
		while(s.hasNext())
		{
			System.out.println(s.next());
		}
		
		System.out.println(l.remove("john cena"));
//		System.out.println(s);
		
	}

}
