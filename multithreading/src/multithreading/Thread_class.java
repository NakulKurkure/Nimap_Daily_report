package multithreading;

class mythread extends Thread
{
	public void run()
	{
		int i=0;
		while(i<100)
		{
			System.out.println("The Name is john "+i);
			i++;	
		}
		
	}
	
	
}

class mythread2 extends Thread
{
	public void run()// to create a new thread.
	{
		int i=0;
		while(i<100)
		{
			System.out.println("The Name is Rock "+i);
			i++;	
		}
		
	}
	
	
}


public class Thread_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mythread m=new mythread();
		mythread2 t=new mythread2();
		m.start();
		t.start();
	}

}
