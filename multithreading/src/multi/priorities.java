package multi;

class p1 extends Thread
{
	
	
	public void run()
	{

			
			System.out.println("In Thread priority"+this.getPriority());//5//Norm priority

	
	}
	
}

public class priorities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		p1 p1=new p1();
		p1.start();
		System.out.println("main Thread priority"+Thread.MAX_PRIORITY);//10
		System.out.println("Main Thread priority"+Thread.currentThread().getPriority());//5//norm Priority
//		System.out.println("main Thread priority"+Thread.NORM_PRIORITY);
		
		
		
	}
	

}
