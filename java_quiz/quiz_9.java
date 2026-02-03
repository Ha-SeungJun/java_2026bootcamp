package java_quiz;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
class Member{
	private String name;
	private int age;
	private String job;
}

public class quiz_9 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("AA", 40, "developer"),new Member("BB", 25, "designer"),new Member("CC", 37, "developer"));
		/*
		 * List 에 저장된 Member 의 평균 나이를 출력
		 */
		
		// 방법 1
		double total = 0;
		for(Member lt : list) {
			total += lt.getAge();
		}
		System.out.println(total/list.size());
		
		
		// 방법 2
		double avg = list.stream().mapToInt(m->m.getAge()).average().getAsDouble();
		System.out.println(avg);
		
		// list 에서 직업이 developer 인 객체만 추려서 새로운 리스트 생성 후 직업 출력
		List<Member> developers = list.stream().filter(v -> v.getJob() =="developer").toList();
		developers.forEach(v -> System.out.println(v)); //v.getjob()
	}
}
