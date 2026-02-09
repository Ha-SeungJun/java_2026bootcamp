package java_20260209;

public class ThreadEx5 {
	public static void main(String[] args) {
		Thread newTh = new Thread(()->{
			while(true) {
				System.out.println(Thread.currentThread().getName() + "이 작업을 함");
			}
		});
		newTh.setDaemon(true);
		newTh.start();
		
		System.out.println("종료");
	}
}
