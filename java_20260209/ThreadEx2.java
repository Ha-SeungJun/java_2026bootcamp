package java_20260209;

import java.awt.Toolkit;

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(getName() + " Thread run");
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5; i++) {
			System.out.println("Hello World!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class yourThread implements Runnable{
	public void run() {
		for(int i = 0 ; i < 5; i++) {
			System.out.println("your Thread..");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx2 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + "실행됨");
		
		//시스템 소리를 내도록 하는 API
		Thread myThread = new MyThread();
		Thread ythread = new Thread(new yourThread());
		
		Thread thread = new Thread(() ->{
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i < 5; i++) {
					toolkit.beep();
				}try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
		});
		
		ythread.start();
		myThread.start();
		thread.start();
		
		for(int i =0; i< 5; i++) {
			System.out.println("dd");
		}try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
