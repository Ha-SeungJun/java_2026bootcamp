package java_20260204;

import java.io.*;
import java.util.Arrays;

public class IOEx2 {
	public static void main(String[] args) {
		try {
//			Writer writer = new FileWriter("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\WriterTest.txt");
//			
//			char a = 'A';
//			writer.write(a);
//			
//			char[] arr = {'c','d','e'};
//			writer.write(arr);
//			
//			writer.write("FGHI");
//			
//			writer.flush();
//			writer.close();
			
			char[] charr = new char[100];
			Reader rd = new FileReader("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\WriterTest.txt");
			
			while(true) {
				int data = rd.read();
				if(data == -1) break;
				System.out.printf("%c",(char)(data));
			}
			
			System.out.println();
			
			char[] charr2 = new char[100];
			Reader rd2 = new FileReader("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\WriterTest.txt");
			while(true) {
				int data2 = rd2.read(charr2);
				if(data2 == -1) break;
				for(int i = 0; i < data2; i++) System.out.printf("%c",(char)(charr2[i]));
				System.out.println();
				System.out.println(Arrays.toString(charr2));
			}
			
			rd.close();
			rd2.close();
		}catch(Exception e) {
			 
		}
	}
}
