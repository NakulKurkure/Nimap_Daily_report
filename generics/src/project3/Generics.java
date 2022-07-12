package project3;

import java.util.ArrayList;

class g1<T1,T2>
{
	int a=122;

	private T1 t1;
	private T2 t2;
	
	public g1(int a, T1 t1, T2 t2) {
		super();
		this.a = a;
		this.t1 = t1;
		this.t2 = t2;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public T1 getT1() {
		return t1;
	}
	public void setT1(T1 t1) {
		this.t1 = t1;
	}
	public T2 getT2() {
		return t2;
	}
	public void setT2(T2 t2) {
		this.t2 = t2;
	}
	
}


public class Generics {

	public static void main(String[] args) {
		
//		ArrayList a=new ArrayList();
//		a.add("String ");
//		a.add(257);
//		a.add(45);
//		a.add(90);
//		int b=(int) a.get(2);//TypeCast to int when we are not using generics(<>) when getting values(.get method)
//		System.out.print(b);
		

//		ArrayList <Integer>a=new ArrayList<Integer>();
//		a.add(1222);
//		a.add(257);
//		a.add(45);
//		a.add(90);
//		int b= a.get(1);//TypeCast to int when we are not using generics(<>) when getting values(.get method)
//		System.out.print(b);
		
//		/class
//		Less code and code is more easily reused.
//		Better performance. 
		
//		type parameters to be used to express dependencies among the types of
//		one or more arguments
//		to a method and/or its return type.
		
		g1<Integer,String> g=new g1(11,22,"NDK");
		g1<Integer,String> g1=new g1(18,20,"HKN");
		int d=g.getA();
		int b=g.getT1();
		String h=g.getT2();
		
		
		int d1=g1.getA();
		int b1=g1.getT1();
		String h1=g1.getT2();
		System.out.println(d);
		System.out.println(b);
		System.out.println(h);
		
		System.out.println(d1);
		System.out.println(b1);
		System.out.println(h1);
		
		
	
		
		
		
		
	}
}
