package java_20260209;

import lombok.Data;

@Data
class SumThread extends Thread{
	private long sum;
	
	public void run() {
		for(int i = 0; i <= 100; i++) {
			sum += 1;
		}
	}
}

class WorkThread extends Thread{
	public boolean work = true;
	public String name;
	
	public WorkThread(String name) {
		setName(name);
	}
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + " : 작업 처리");
			}else {
				Thread.yield();
			}
		}
	}
}

public class threadEx3 {
	public static void main(String[] args) {
		// sleep(), join() : 호출한 쓰래드가 일시정지
		//실행대기 상태로 가려면 조인을 가진 쓰래드가 런을 모두 끝낸 상태가되어야함
		// yield() : 실행 상태에서 다른 쓰래드에게 실행을 양보 후 대기 상태가됨
		////////////////////////////////////////////////////////////
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		try {
			//Thread.sleep(500);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workThreadA.work = false;
		
		try {
			//Thread.sleep(500);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workThreadA.work = true;
		////////////////////////////////////////////////////////////
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			//Thread.sleep(500);
			sumThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1 부터 100 까지의 합 : " + sumThread.getSum());
	}
}
