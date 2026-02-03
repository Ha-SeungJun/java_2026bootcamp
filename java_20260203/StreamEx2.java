package java_20260203;

import java.util.*;

public class StreamEx2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("홍길동", 85,"남자"));
		list.add(new Student("김춘추", 90,"남자"));
		list.add(new Student("박세영", 92,"남자"));
		
		list.stream().mapToInt(v->v.getScore()).forEach(v->System.out.println(v));
		
		List<String> list1 = new ArrayList<String>();
		list1.add("자바 배우기");
		list1.add("파이썬 독학");
		list1.add("러스트 공부하기");
		
		list1.stream().flatMap(t->Arrays.stream(t.split(" "))).forEach(w ->System.out.println(w));
		
		List<String> list2 = Arrays.asList("10","20","30","40","50");

		
		list2.stream().flatMapToInt(t->{
			String[] strArr = t.split(",");
			int[] intArr = new int[strArr.length];
			for(int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(n -> System.out.println(n));
		
		List<Student> list3 = new ArrayList<Student>();
		list3.add(new Student("김김김", 32,"남자"));
		list3.add(new Student("이이이", 21,"남자"));
		list3.add(new Student("박박박", 45,"남자"));
		
		//compareTo 때문에 score 을 기준으로 정렬(?)
		list3.stream().sorted().forEach(t->System.out.println(t));
	}
}
