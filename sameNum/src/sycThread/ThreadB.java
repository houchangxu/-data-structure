package sycThread;


public class ThreadB extends Thread{

	
	private Service service;

	public ThreadB(Service service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.c();
	}
	
}
