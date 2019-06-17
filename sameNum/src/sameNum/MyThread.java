package sameNum;

public class MyThread extends Thread{
	private int i = 5;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	synchronized public void run() {
		if(i>0){
			i--;
			System.out.println(i+"*********"+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		MyThread my = new MyThread();
		while(my.getI()>0){
			Thread t1 = new Thread(my,"A");
			Thread t2 = new Thread(my,"B");
			t1.start();
			t2.start();
		}
	}

}
