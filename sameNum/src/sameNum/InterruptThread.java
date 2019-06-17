package sameNum;

public class InterruptThread extends Thread{

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5000000; i++) {
				if(this.interrupted()){
					System.out.println("Í£Ö¹×´Ì¬");
					throw new InterruptedException();
				}
				System.out.println("i=" + i);
			}
			System.out.println("»¹ÔÚÊä³ö");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InterruptThread i = new InterruptThread();
		i.start();
		try {
			Thread.sleep(1000);
			i.interrupt();
			System.out.println(i.interrupted());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
