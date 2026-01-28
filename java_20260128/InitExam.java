package java_20260128;

public class InitExam {
	
	public InitExam() {System.out.println("생성자 호출");}
	
	static {
		System.out.println("클래스의 스태틱 초기화 블락 수행");
	}
	{
		System.out.println("인스턴스의 초기화 블락 수행");
	}
	
	
	void doSome() {System.out.println("인스턴스 두썸 메서드 수행");}
	
	public static void main(String[] args) {
		System.out.println("메인 메서드 실행");
		new InitExam();
	}
}
