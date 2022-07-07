package Set_In;

import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> h=new HashSet<>();
		h.add(123);
		h.add(234);
		h.add(345);
		h.add(null);
		h.add(null);
		h.add(567);
		
		System.out.println(h);
		
		System.out.println(h.remove(null));
		System.out.println(h);
		
		System.out.println(h);
		
		
//		h.removeAll(h);
		
		for(Integer i:h)
		{
			System.out.println(i);
		}
		
		
		
	}

}
