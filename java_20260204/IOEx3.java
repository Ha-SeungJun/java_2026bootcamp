package java_20260204;
import java.io.*;
import java.nio.CharBuffer;

public class IOEx3 {
	public static void write(String str) throws Exception {
		OutputStream o = new FileOutputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\WriterTest.txt");
		Writer writer = new OutputStreamWriter(o,"UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception{
		//write("문자 변환 스트림을 사용하는 예시");
	
		//public static String read() throws Exception{--------}
		InputStream input = new FileInputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\WriterTest.txt");
		Reader rd = new InputStreamReader(input);
		
		char[] ch = new char[100];
		
		int num = rd.read(ch);
		String str = new String(ch,0,num);
		System.out.println(ch);
		System.out.println(str);
		rd.close();
		//리더에 인풋스트림리더 를 꼽고 인풋스트림리더에는 파일인풋스트림을 꽂기
		// 스트림 연결 후 100사이즈 찰 배열 생성해서 리덜을 이용해서 읽고 데이터를 스트링 타입의 변수에 담아 리턴
	}
}
