package java_20260130_langex;

import java.io.*;
import java.util.*;

public class ExceptionExam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				
				System.out.println("가위바위보(1,2,3) 입력 ");
				int user=0;
				
				try {
					//user = sc.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("예외처리");
					// System.out.println(e.getMessage());
					e.printStackTrace();
				}
				System.out.println(user);
				
				try {
					FileReader fr = new FileReader("msg.txt");
					
					while(true) {
						int i = fr.read();
						if ( i == -1)break;
						System.out.println(i);
						System.out.println((char)(i));
					}
					
				} catch (FileNotFoundException e) { //작은 순에서 큰 순으로 캣치 / 묶어서 Exception 으로 잡을 수 있음
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println(e.getMessage());
				} catch (IOException e) {System.out.println(e.getMessage());}
				
	}
}
