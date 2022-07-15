import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmap {

	public static void main(String[] args) {
		
		//Map Interface-----
		
		//key value pair//doesn't allow duplicate keys but allow values
		//asending values.
//		Is HashMap immutable?---> yes
//		contains only unique keys.
//		HashMap uses a technique called Hashing. 
//		Hashing is a technique of converting a large String to a small String.
//		Java HashMap may have one null key and multiple null values.
		// hash code is an integer value that is linked with each object. 
		//When two or more keys are mapped to the same value using these hashing methods.
		HashMap<Integer,String> hm=new HashMap<>();
		hm.put(1, "Shahan");
		hm.put(2, "Harshal");
		hm.put(3, "Saurabh");
		hm.put(5, "manish");
		hm.put(4, "Manish");
		
		
		HashMap<Integer,String> hm1=new HashMap<>();
		hm1.put(1, "Shahan");
		hm1.put(2, "Harshal");
		hm1.put(3, "Saurabh");
		hm1.put(5, "manish");
		hm1.put(4, "Manish");
		
	
//		hm1.equals(hm);
		System.out.println(hm1.equals(hm));
		//entrySet()---Returns a Set view of the mappings contained in this map        
//		for(Entry<Integer, String> m:hm.entrySet()){  
//			   System.out.println(m.getKey()+" "+m.getValue());  
//			  }  
//		
		
		for(Map.Entry m:hm.entrySet())
		{  
		   System.out.println(m.getKey()+" "+m.getValue());  
		}  
		
		for(Map.Entry m:hm1.entrySet())
		{  
		   System.out.println(m.getKey()+" "+m.getValue());  
		}  
		
//		
		
		
		System.out.println(hm.get(1)); //get values
		
		System.out.println(hm.get(2));
		
		
		
	}

}
