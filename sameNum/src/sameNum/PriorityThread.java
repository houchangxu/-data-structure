package sameNum;

public class PriorityThread extends Thread{

	@Override
	public void run() {
		System.out.println("this:"+this.getName() +"~~~~~~~"+this.getPriority());
		Thread2 t = new Thread2();
		t.setName("thread2");
		t.start();
		
	}
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName()+"~~"+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(MAX_PRIORITY);
		PriorityThread p = new PriorityThread();
		System.out.println(Thread.currentThread().getName()+"~~"+Thread.currentThread().getPriority());
		p.setName("priorityThread");
		p.start();
	}
}
class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("this:"+this.getName() +"~~~~~~~"+this.getPriority());
	}
}

