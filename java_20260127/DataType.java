package java_20260127;

public class DataType {

	public static void main(String[] args) {
		byte b = 127;
		int s = 128;
		
		s = b+1;
		
		long lo = 8L;
		
		int in = (int)(lo+1); // 큰 타입으로 변환시켜 에러발생 lo = 8bit
		
		//casting 연산자 : 우측 데이터 타입을 지정된 타입으로 강제 변환
		
		float f = 3.14f;
		
		f = in;
		long in_1 = (long)f;
		
		System.out.println(in);
		
		
		////////////////////////////////////////////////////////////////////
		String name = "Ha_SeungJun";
		System.out.println("안녕하세요 \n\t" + name + "님");
		
		int age = 25; String add = "춘천";
		
		System.out.printf("%s 나이는 %d 입니다 \n",name,age);
		System.out.printf("%s 나이는 %d 입니다. 주소는 %s입니다.\n",name,age,add);
		
		System.out.printf("자리수 : %04d \n",1);
		System.out.printf("자리수 : %04d \n",10);
		System.out.printf("자리수 : %04d \n",100);
		System.out.printf("자리수 : %04d \n",1000);
		
		System.out.printf("자리수 : %.2f \n",1.23456f);
	}
}
