package java_20260202;

import java.io.IOException;
import java.util.Properties;

public class propertiesExam {
	public static void main(String[] args) throws IOException {
		Properties  properties = new Properties();
		properties.load(propertiesExam.class.getResourceAsStream("db.properties"));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(admin);
	}
}
