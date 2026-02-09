package java_20260209;

import java.awt.Toolkit;

public class ThreadEx1 {
	public static void main(String[] args) {
		//시스템 소리를 내도록 하는 API
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		try {
			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for(int i = 0; i < 5; i++) {
			System.out.println("띵동");
		}try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
