package java_20260203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamEx3 {
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		Arrays.stream(intArr).filter(v -> v%2==0).peek(v -> System.out.println(v)); //peek 최종 처리 안하면 값 안 나옴
		
		int total = Arrays.stream(intArr).filter(v -> v%2==0).peek(v -> System.out.println(v)).sum();
		System.out.println(total);
		
		boolean result = Arrays.stream(intArr).allMatch(v -> v%2 == 0);
		System.out.println(result);
		
		boolean result2 = Arrays.stream(intArr).noneMatch(v -> v%3 == 0);
		System.out.println(result2);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		List<Integer> list = new ArrayList<Integer>();
		//double avg = list.stream().mapToInt(Integer :: intValue).average().getAsDouble();
		 OptionalDouble optional = list.stream().mapToInt(Integer :: intValue).average();
		 if(!optional.isEmpty()) System.out.println("평균 : " + optional.getAsDouble());
		 else System.out.println("평균 : " + 0);
		 
		 double avg = optional.orElse(0.0);
		 System.out.println("방법 2) 평균 : " + avg);
		 
		 optional.ifPresent(v-> System.out.println("방법 3) 평균 : " + v));
		 
		 Student str = null;
	}
}
