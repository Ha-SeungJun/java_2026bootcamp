package java_20260128;
	//자바 클래스 : 실제 어플리케이션이 수행할때 사용되는 객체의 설계도
	//이 설계도에 우리가 목적하는 업무를 정의하고, 객체화 시켜 수행하도록 함
	
	//객체지향에서는 클래스 설계가 무척 중요
	
	//클래스는 크게 3형식 구조
	//1. 필드 : 멤버 필드라고 하며 객체의 상태를 나타내는 변수
	
	//2. 생성자(constructor) : 메서드의 일종, 형식은 비슷하지만 메서드와 다름, 리턴타입 X, 이름 == 클래스명 
	//			클래스 바탕으로 실제 객체를 생성하는 역할, 객체 및 필드 초기화 역할, 목적에 따라 초기화 메서드 호출 역할
	
	//3. 메서드 : 클래스 또는 객체가 수행할 행위를 정의
	//			객체와 유기적인 작업은 이 메서드를 이용해서 주로 함, 필요에 따라 필드값을 set/get 함
	//---------------------------------------------------------------------------------------------------
	//접근 제어자 : private > default > protected > public
	// class에는 default 와 public , 나멈지 필드 생성자 메서드에는 위 중 하나 선언해서 접근 제어
	//---------------------------------------------------------------------------------------------------
	//학생들의 객체를 생성, 정보를 출력하는 클래스 정의 
	
class FullStackStudent{
	private String name; // 클래스 내부 변수는 멤버필드
	private int age;
	private char grade;
	//생성자의 문법
	// [접근제어자] 클래스명([파라미터)]{생성자 코드}
	public FullStackStudent() {
		this.name = null;
		this.age = 0;
		this.grade = ' ';
	}
	//생성자 오버로딩
	public FullStackStudent(String n) {
		this.name = n;
	}
	
	public FullStackStudent(String n, int a) {
		this(n);
		this.age = a;
	}
	
	public FullStackStudent(String n, int a, char g) {
		this.name = n;
		this.age = a;
		this.grade = g;
	}
	
	public void face() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.grade);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getName(int id) {return this.name;}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class ClassExam {
	public static void main(String[] args) {
		FullStackStudent me = new FullStackStudent("하승준",25,'4'); //instantiation
		FullStackStudent you = new FullStackStudent("준승하",52,'1');
		FullStackStudent you2 = new FullStackStudent();
		FullStackStudent hj = new FullStackStudent("hj");
		   
		me.face();
		you.face();
		you2.face();
		hj.face();
		
		System.out.println(me.getName());
	}
}
