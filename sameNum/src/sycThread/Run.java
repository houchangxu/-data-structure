package sycThread;

public class Run {
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA ta = new ThreadA(service);
		ta.setName("A");
		ta.start();
		ThreadB tb = new ThreadB(service);
		tb.setName("B");
		tb.start();
	}
}
