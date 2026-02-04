package java_20260204;
import java.io.*;

class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611019563454516193L;
	
	private String id,name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return id + " : " + name;
	}
}
public class IOEx5 {
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\src\\java_20260204\\IOEx5.java"));
//		
//		int lineNo = 1;
//		while(true) {
//			String str = br.readLine();
//			if(str == null) break;
//			System.out.println(lineNo + "\t" + str);
//			lineNo++;
//		}br.close();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\src\\java_20260204\\IOEx5test.txt"));
		Member m1 = new Member("aa","java");
		
		oos.writeObject(m1);
		oos.flush();
		oos.close();
		
		//읽을때는 쓴 순서 그대로 읽기
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("C:\\Users\\hallyms\\eclipse-workspace\\javaFund\\src\\java_20260204\\IOEx5test.txt"));
		
		Member m2 = (Member)ios.readObject();
		
		ios.close();
		System.out.println(m2);
	}
}
