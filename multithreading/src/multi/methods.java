package multi;

class mythread extends Thread
{
	
	public void run()
	{
//		int i=0;
		while(true)
		{
			System.out.println("In the Run method");
//			i++;
		}
		
	}
	
}

class mythread1 extends Thread
{
	
	public void run()
	{
		System.out.println("In the Run1 method");
	}
	
}

public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mythread m=new mythread();
		mythread1 m1=new mythread1();
		m.start();
		try {
//			m.join();
			m.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m1.start();
	}

}
