package java_20260129_inheri;

/*
 * 자바 클래스 간의 상속 : 클래스간에는 상속을 통해 기능과 속성을 자식 클래스가 사용할 수 있도록함
 * 클래스 간 상속은 extends 라는 키워드르릍 ㅗㅇ해 ex > A  extends B 형식에서 b는 a를 상속한다고 선언
 * 
 *  위 처럼 상속하면 에이 클래스 필드 메서드는 비 클래스에서 사용할 수 있도록 상속
 *  
 *  상속은 클래스 간 선언을 통해 이뤄지지만 실제 사용시 객체가나의 상속을 통해 이뤄짐
 *  
 *  클래스 간의 상속은 단일 상속만 가능. 비 클래스는 오직 하나의 부모 클래스만 상속, 다른 클래스를 통시 상속 못함
 *  
 *  만약 둘다 상속 받고 싶으면 순차적으로 상속받아야함
 *  >이렇게 상속할 경우 필드 메서드는 상속하지민 생성자는 하지 않음
 *  때문에 자식은 부모의 생성자중 하나를 반드시 호출해서 객체를 발생시켜야함
 */

class A{
	public int a;
	
	public A(int a) {
		this.a = a;
	}
	
	public final void a() {
		System.out.println("A클래스의 a메서드 호출");
	}
	
}

class B extends A{
	public B(int b){super(10);}
	public static final double PI = 3.14;
	public int b;
	public void b() {
		System.out.println("B 클래스의 b메서드 호출");
	}
	
	//public void a() {}
}
public class InheritanceExam {
	public static void main(String[] args) {
		A a = new A(10);
		a.a();
		B b = new B(20);
		b.a();
	}
}
