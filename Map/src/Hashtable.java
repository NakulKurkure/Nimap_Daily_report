
import java.util.*;
public class Hashtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Hashtable is an array of a list.
//		 Hashtable class doesn't allow null key or value.
		//The initial default capacity of Hashtable class is 11.
		// The position of the bucket is identified by calling the hashcode() method.
		//dont allow insertion order
		//
		Map<Integer,String> ht=new java.util.Hashtable<>();
		ht.put(1, "NDK");
		ht.put(2, "MDK");
		ht.put(3, "DDK");
		ht.put(4, "SDK");
//		ht.put(null, "SDK");
		
		for(Map.Entry m:ht.entrySet())
		{  
		   System.out.println(m.getKey()+" "+m.getValue());  
		}  
		
		System.out.println(ht.remove(1));//1
		System.out.println(ht.get(2));//1
//		for(Map.Entry m:ht.entrySet())
//		{  
//		   System.out.println(m.getKey()+" "+m.getValue());  
//		}  
		
		System.out.println(ht);
		// we specify the if and else statement as arguments of the method  
		System.out.println(ht.getOrDefault(2, "NOT FOUND"));
		
		ht.putIfAbsent(5, "NMKKK");
		System.out.println(ht);
		
		System.out.println(ht.hashCode());//
		
		
		
	
		
		
	}

}
