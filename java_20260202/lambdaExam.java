package java_20260202;

import java.util.ArrayList;

interface A{
	void a();
}

interface Calculable{

	void calc(int x,int y);
}
@FunctionalInterface
interface Action2{
	void action2(String name, String job);
}

@FunctionalInterface
interface Speakable{
	void speak(String content);
}

@FunctionalInterface
interface Addable{
	double add(double x, double y);
}
class CalSub1 implements Calculable{
	public void calc(int x, int y) {System.out.println(x+y);};
}
	
class CalSub2 implements Calculable{
	public void calc(int x, int y) {System.out.println(x-y);};
}
	
interface Workable{
	void work();
}
class Person{
	public void action(Workable workable) {
		workable.work();
	}
	public void addAction(Addable addble) {
		double result = addble.add(10,4);
		System.out.println(result);
	}
}



class SomeOne{
	void doSomething(Action2 action) {
		action.action2("홍길동","프로그래밍");
	}
	void doSomthing2(Speakable speakable) {
		speakable.speak("Hello");
	}
}

public class lambdaExam {
	
	public static void action(Calculable calculable){
		int x = 10;
		int y = 4;
		calculable.calc(x, y);
	}
	
	public static void action2(Calculable calculable) {
		SomeOne ironMan = new SomeOne();
		ironMan.doSomething((name,job)->{
			System.out.println(name + "이 ");
			System.out.println(job + "을 합니다.");
		});
		
		ironMan.doSomthing2((content)->{
			System.out.println(content + "를 말합니다.");
		});
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("일");
		list.add("2");
		list.add("삼");
		
		list.forEach(t -> System.out.println(t));
	}

	public static void main(String[] args) {
		Person me = new Person();
		me.action(new Workable() {
			public void work() {
				System.out.println("출근 체크");
				System.out.println("java programing");
			}
		});
		
		new Person().action(()->System.out.println("퇴근"));
		
		action(new Calculable() {
			public void calc(int x, int y) {
				int result = x+y;
				System.out.println(result);
			 }
		});
		
		action((j,k)->{
			int result = j-k;
			System.out.println(result);
		});
		
		new A() {
			public void a() {
				System.out.println("a() override");
			}
		};
		
		Person p = new Person();
		p.addAction((x,y)->{
			double result = x+y;
			return result;
		});
		
		p.addAction((x,y)->{
			return (x-y);
		});
		
		p.addAction((x,y)->(x-y));
	}
}
