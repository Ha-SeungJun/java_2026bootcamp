package java_20260203_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOEx1 {
	public static void main(String[] args) {
		// 데이터 입출력을 위해 반드시 스트림에 연결
		// 스트림은 단방향
		
// 		크게 두 종류로 분류
//		1. 그림 동영상 음성 문자 등 모든 종류에 데이터 > 바이트
//		2. 문자만 입출력 : 문자 스트림
		
		try {
			// outputStream 파일 만들기 
//			OutputStream out = new FileOutputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\test4.db");
			//test1
//			byte a = 10;
//			byte b = 20;
//			byte c = 30;
//			
//			out.write(a);
//			out.write(b);
//			out.write(c);
//			
			//test2
//			byte[] barr = {10,20,10,30,50};
//			out.write(barr);
//			
			//tset3
//			out.write(barr,2,3);
//			out.flush();
//			out.close();
			
//			InputStream is = new FileInputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\test2.db");
//			byte[] data = new byte[1];
//			while(true) {
//				int num = is.read(data);
//				if(num==-1)break;
//				for(int i = 0; i < num; i++) System.out.println(data[i]);
//			}
//			
			
//			while(true) {
//				int data = is.read();
//				
//				if(data == -1)break;
//				
//				System.out.println(data);
//			}
			
			String banana = "C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\banana.jpeg";
			String copy = "C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\copy.jpeg";

			OutputStream os = new FileOutputStream(copy);
			InputStream is = new FileInputStream(banana);
			
			byte[] data = new byte[1024];
			
			while(true) {
				int num = is.read(data);
				if(num == -1) break;
				os.write(data,0,num);
			}
			os.flush();
			os.close();
			is.close();
			//			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
