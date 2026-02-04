package java_20260204;
import java.io.*;

public class IOEx4 {
	public static void main(String[] args) throws Exception{
		String originalFilePath = IOEx4.class.getResource("banana.jpeg").getPath();
		System.out.println(originalFilePath);
		
		String targetFilePath1 = "C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\banana.jpeg";
		FileInputStream fis = new FileInputStream(originalFilePath);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
		
		String originalFilePath2 = IOEx4.class.getResource("banana.jpeg").getPath();
		String targetFilePath2 = "C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp\\banana.jpeg";
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long nonBufferTime = copy(fis,fos);
		System.out.println(nonBufferTime);
		
		long BufferTime = copy(bis,bos);
		System.out.println(BufferTime); 
	}
		
	private static long copy(InputStream fis, OutputStream fos) throws IOException{
		long start = System.nanoTime();
		
		while(true) {
			int data = fis.read();
			if(data == -1) break;
			fos.write(data);
		}fos.flush();
		long end = System.nanoTime();
		return (end - start);
	}

}
