package java_quiz;

import java.nio.charset.Charset;
import java.util.SortedMap;

//email 을 변수에 담아 @ 을 기준으로 id 분리하고 char 배열로 변환해서 그것의 길이와, 값을 출력하기

public class quiz_4 {

	public static void main(String[] args) {
		String email = "asoc1037@naver.com";

		String[] check = email.split("@");
		
		// char 에 넣긴했는데 쓸 이유가 없긴해
		// char[] id = check[0].toCharArray();
		
		System.out.printf("id 길이 : %d\nid 값 : %s\n", check[0].length(),check[0]);
		
		//굳이 id 쓸거면 for 사용, 출력 ;  
		//split 말고 @ 인덱스 위치 찾아서 그전까지 반복돌리며 char 에 저장 / 이후 출력하는 것이 의도일 것 같긴한데 
		//더 쉽게해야지
		
		//다음 문제
		// charset 인터페이스를 보고 문자셋을 리턴하도록 하는 메서드를 이용해서 자바에서 지원하는 문자셋이 무엇인지 출력
		SortedMap<String, Charset> cset = Charset.availableCharsets();
		System.out.println(cset);
		
		
	}
}
