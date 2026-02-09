package java_20260209;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 목적에 맞게 한 번에 여러개를 생성해 풀로 관리
// 수행한 쓰레드는 파괴되지않는다. 다시 재사용가능 

public class ThreadpoolEx {
	public static void main(String[] args) {

		String[][] mails = new String[1000][3];
		for(int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@hallym.ac.kr";
			mails[i][1] = "member" + i + "@hallym.ac.kr";
			mails[i][0] = "2026 학사과정 공지";
		}
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 1000; i++) {
			final int idx = i;
			
			executorService.execute(new Runnable() {
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					
					System.out.println("[" + thread.getName() + "]" + from + "==>" + to + ": " + content);
				}
			});
		}
		executorService.shutdown();
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		
//		executorServiece.execute(null);
//		executorService.shutdown();
	
	}
}
