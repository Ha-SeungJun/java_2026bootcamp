package java_Assignment;

import java.util.Scanner;

public class score2 {
		//quiz_3(score.java)에서 다중 배열로 학생 3명으로 퀴즈3과 똑같이
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			float test[][] = new float[3][5]; //국 영 수 총 평
			String cls[] = new String[]{"국어", "영어", "수학"};
		
			
			//점수 받고
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					do {
						System.out.printf("%d 번쨰 학생 %s점수를 입력해 주세요 : ",i+1,cls[j]);
						int input = sc.nextInt();
						test[i][j] = input;
					}while(test[i][j] < 0 || test[i][j] > 100);
				}
			}
			
			//총점 평균 저장 및 출력
			for(int i = 0; i < 3; i++) {
				test[i][3] = test[i][0] + test[i][1] + test[i][2]; 
				test[i][4] = test[i][3]/3;
			
				System.out.println("--------------------");
				System.out.printf("%d학생 성적 \n",i+1);
				//결과 출력
				for(int j = 0; j < 3; j++) {
					System.out.printf("%s : %.0f \n",cls[j],test[i][j]);
				}
				
				System.out.printf("총점 : %.0f \n", test[i][3]);
				System.out.printf("평균 : %.2f \n", test[i][4]);
				
				String grade = "";
				switch((int)(test[i][4])/10) {
					case 10: 
					case 9 : grade = "A";break;
					case 8 : grade = "B";break;
					case 7 : grade = "C";break;
					default : grade = "D";
				}
				System.out.printf("학점 : %s \n",grade);
			}
						
		}
}
