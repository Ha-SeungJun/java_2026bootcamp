package java_20260202;

interface Calcuable2{
	double calc(double x, double y);
}
class Person2{
	public void doSome(Calcuable2 calcualble2) {
		double res = calcualble2.calc(10,4);
		System.out.println(res);
	}
}

class Computer{
	public static double staticMethod(double x, double y) {
		return x+y;
	}
	
	public double instanceMethod(double x, double y) {
		return x*y;
	}
}



public class lambdaExam2 {
	public static void main(String[] args) {
		//메소드를 참조하는 람다식
		//클래스 :: 메서드
		// 인스턴스변수 :: 메서드
//		
//		Math.max(1, 0);
//		(left, right) -> Math.max(left, right);
//		
//		Math :: max;
		Person2 p = new Person2();
		
		p.doSome((x,y)->Computer.staticMethod(x, y));
		//위와 동일
		p.doSome(Computer :: staticMethod);
		
		Computer computer = new Computer();
		p.doSome(computer :: instanceMethod);
	}
}
