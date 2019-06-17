package sycThread;

public class Service {

	private String str = new String();
	boolean flag = true;
	 public void a(){
		 try {
			 
			 System.out.print( Thread.currentThread().getName()+" ssssssssssssssssssssssssssbegin");
			 Thread.sleep(3000);
			 synchronized(this){
					for(int i = 0;i<5000;i++){
						System.out.print(i +Thread.currentThread().getName());
					}
			 }
			 System.out.print( Thread.currentThread().getName()+" sssssssssssssssssssssssssssssend");
		 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	 public  void b(){
		 while(flag){
			 
		 }
		System.out.println( "b begin");
	
	}
	 public  void c(){
			System.out.println( "c begin");
		
		}
}
