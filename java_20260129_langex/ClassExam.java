package java_20260129_langex;

import java.lang.reflect.Constructor;

public class ClassExam {
	public static void main(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("java_20260129_langex.ClassExam");
		
		System.out.println(cls.getName());
		
		Constructor<String>[] cons = cls.getConstructors();
		for(Constructor<String> con : cons) {
			System.out.println(con);
		}
		Constructor<String>[] method = cls.getConstructors();
		for(Constructor<String>methods : method) {
			System.out.println(methods.getName());
			System.out.println(methods.getParameterCount());
		}
	}
	
	void a() {
		

	}
	
}
