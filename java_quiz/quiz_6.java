package java_quiz;

import java.util.HashSet;
import java.util.Set;

/*
 * hashset 에 strudent 를 저장 학번이 같으면 동일한 student 객체라고 인식해서 중복 X
 * Student 의 학번이 hash 코드라고 생각하고 student 클래스를 정의
 */

class Student{
	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	//
	public int hashCode() {
		// TODO Auto-generated method stub
		return studentNum;
	}
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student target) {
			return (target.studentNum == studentNum);
		}else {
			return false;
		}
	}
}

public class quiz_6 {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "제니"));
		set.add(new Student(2, "로제"));
		set.add(new Student(1, "리사"));
		
		System.out.printf("저장된 객체(학생) 수 : %d \n", set.size());
	}
}
