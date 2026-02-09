package java_20260209;

import lombok.Data;

//동기화는 크게 2가지. 메서드를 통해 공유 필드 동기화, 동기화 블락을 통해 동기화

class Calculator{
	private int memory;
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	public void setMemory2(int memory) {
		
	}
}

class UserThread1 extends Thread{
	private Calculator calculator;
	
	public UserThread1() {
		setName("user1Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public void run() {
		calculator.setMemory(100);
	}
}

class UserThread2 extends Thread{
	private Calculator calculator;
	
	public UserThread2() {
		setName("user2Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	

	public void run() {
		calculator.setMemory(50);
	}
}
public class ThreadEx4 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		UserThread1 userThread1 = new UserThread1();
		userThread1.setCalculator(calculator);
		userThread1.start();
		
		UserThread2 userThread2 = new UserThread2();
		userThread2.setCalculator(calculator);
		userThread2.start();
	}
}
