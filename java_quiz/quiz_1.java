package java_quiz;

public class quiz_1 {
	public static void main(String[] args) {
		/*
		 * 과수원을 하는데
		 * 배 오랜지 사과를 하루에 각 5,7,4개를 생산
		 * 하루 기준 시간당 총 생산량을 출력
		 */
		
		float a = 5+7+4;
		float answer = a / 24f;

		System.out.printf("시간당 총 생산량: %.2f개\n", answer);
		
		
		//////////////////////////////////////////////////////////////////
		
		char ch1 = 'a';
		char ch2 = '가';
		
		ch1 = ++ch1;
		System.out.println(ch1);
		//ch2 = -1;
		System.out.println((int)(ch1));
	}
}
