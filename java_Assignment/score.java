package java_Assignment;

import java.util.Scanner;

public class score {
	//score.java 파일을 생성해서 아래와 같은 결과를 도출하는 로직을 작성 >>>>>>>>>>>>quiz_3로 대체함
	//Why? 퀴즈 문제 정리를 위해..
	//학생의 성적을 국영수 입력 받아 총점 평균 학점을 출력 
	//프로그램이 시작되면 각 과목을 입력 받도록하고 입력된 점수는 반드시 0 ~ 100점 사이 
	//범위 벗어나면 해당 과목을 다시 입력 받아야함
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float test[] = new float[5]; //국 영 수 총 평
		String cls[] = new String[]{"국어", "영어", "수학"};
	
		
		//점수 받고
		for(int i = 0; i < 3; i++) {
			do {
				System.out.printf("%s점수를 입력해 주세요 : ",cls[i]);
				int input = sc.nextInt();
				test[i] = input;
			}while(test[i] < 0 || test[i] > 100);
		}
		
		//
		test[3] = test[0] + test[1] + test[2]; 
		test[4] = test[3]/3;
		//
		
		
		//결과 출력
		for(int i = 0; i < 3; i++) {
			System.out.printf("%s : %.0f \n",cls[i],test[i]);
		}
		
		System.out.printf("총점 : %.0f \n", test[3]);
		System.out.printf("평균 : %.2f \n", test[4]);
		
		String grade = "";
		switch((int)(test[4])/10) {
			case 10: 
			case 9 : grade = "A";break;
			case 8 : grade = "B";break;
			case 7 : grade = "C";break;
			default : grade = "D";
		}
		System.out.printf("학점 : %s",grade);
		
	}
}