package java_20260203;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx4 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("홍길동", 85,"여자"));
		list.add(new Student("김춘추", 90,"남자"));
		list.add(new Student("박세영", 92,"남자"));
		list.add(new Student("최승길", 78,"여자"));
		
		List<Student> maleList = new ArrayList<Student>();
		
		for(Student student : list) {
			if(student.getSex().equals("남자")) maleList.add(student);
		}
		
		List<Student> maleList2 = list.stream().filter(s -> s.getSex().equals("남자")).collect(Collectors.toList());
		
		List<Student> maleList3 = list.stream().filter(s-> s.getSex().equals("남자")).toList();
		
		System.out.println(maleList);
		System.out.println(maleList2);
		System.out.println(maleList3);
		
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(t->t.getName(), t -> t.getScore()));
		
		System.out.println(map);
	}
}
