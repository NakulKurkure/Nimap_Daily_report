package multithreading;


class mythreads implements Runnable
{

	public void run() {
		
		int i=0;
		while(i<100)
		{
			System.out.println("In While loop 1"+i);
			i++;
		}
		
		
	}
	
}

class mythread1 implements Runnable
{

	public void run() {
		
		int i=0;
		while(i<100)
		{
			System.out.println(" While loop 2"+i);
			i++;
		}
		
		
	}
	
}

public class Runnable_interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mythreads m=new mythreads();
		Thread t=new Thread(m);
		
		mythread1 m1=new mythread1();
		Thread t1=new Thread(m1);
		
		t.start();
		t1.start();
	}

}
