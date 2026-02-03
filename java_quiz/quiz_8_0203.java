package java_quiz;

import java.util.Arrays;
import java.util.List;

/*
 * List 에 저장되어 있는 String 요소에서 대소문자 상관없이 java 라는 단어가 포함된 영문자만 필터링해서 출력
 * 빈칸 코드 채우기
 */
public class quiz_8_0203 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a Java class ", "Lambda 표현식을 배웁니다", "java8 부터 람다가 지원됩니다.");
	
		list.stream().filter(v -> v.toLowerCase().indexOf("java") >= 0).forEach(v->System.out.println(v)); 
		
	}
}
