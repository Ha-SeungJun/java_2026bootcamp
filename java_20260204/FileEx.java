package java_20260204;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\parent");
		if(!file.exists()) file.mkdir();
		
		File file2 = new File(file, "chid.dat");
		file2.createNewFile();
		
		File file3 = new File("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\temp");
		if(file3.exists()) {File[] files = file3.listFiles();
							SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a HH:mm");
							
							for(File f : files) {
								System.out.printf("%-25s",sdf.format(new Date(f.lastModified())));
								
								if(file.isDirectory()) System.out.printf("%-10s%-20s","<DIR>",f.getName());
								else System.out.printf("%-10s%-20s",f.length(),f.getName());
								System.out.println();
							}
		}
	}
}
