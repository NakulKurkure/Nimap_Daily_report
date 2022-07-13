


//Constructor from thread class
class Mythread extends Thread
{
	
	//constructor thread class
	Mythread(String name)
	{
		super(name);
	}
	
	
	public void run()
	{
		int i=19;
		System.out.println("In the Thread.....");
	}
}

public class multithread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Mythread m=new Mythread("manish");
		m.start();
		
		System.out.println("The id is"+m.getId());//14
		System.out.println(""+m.getName());//manish
		
		m.setName("nakul");//setname
		System.out.println(""+m.getName());//getname
		
		
	}

}
