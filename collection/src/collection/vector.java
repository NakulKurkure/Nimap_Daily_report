package collection;

import java.util.Vector;

public class vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Vector<Integer> v=new Vector<>();
		v.add(12);
		v.add(23);
		v.add(34);
		v.add(45);
		v.add(56);
		v.add(67);
		System.out.print(v+"\n");
		
		v.addElement(90);
		System.out.print(v+"\n");
		
		v.remove(0);
		System.out.print(v+"\n");
		
		v.add(1, 99);
		System.out.print(v+"\n");
		
		v.set(2, 77);
		System.out.print(v+"\n");
		
		System.out.println(v.indexOf(77)+"\n");
		System.out.println(v.get(2));
		
		System.out.println(v.size());
		
		System.out.println(v.capacity());

		
		
	}

}
