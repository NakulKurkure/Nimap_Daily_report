package project3;


public class comparing_objects {

	int a;
	int b;
	
	
	public comparing_objects(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		comparing_objects c=new comparing_objects(1,2);
		comparing_objects c1=new comparing_objects(1,2);
		
		System.out.println(c==c1);//pointing on diff. location//address compare
//		
		System.out.println(c.equals(c1));//content compare
//		
		
		var b=c;
		System.out.println(c==b);//pointing on same location
		System.out.println(c.equals(b));
		
		
		
	}

}
