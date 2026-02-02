package java_20260202;


class Box<T>{ //이렇게 타입 지정 시 컨텐트는 반드시 클래스나 인터페이스 타입이여야함, 즉 객체타입임 / p 타입은 wrapping 되서 사용
	public T content;
	
}

class Product<K,M>{
	private K kind;
	private M model;
	
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}

}

class Tv{
	
}

class Car{
	public void run() {
		System.out.println("달린다. 자동차");
	}
}

interface Rentable<P>{
	P rent();
}

class Home{
	public void turnOnLight() {
		System.out.println("전등을 켬");
	}
}

class HomeAgency implements Rentable<Home>{
	public Home rent() {
		return new Home();
	}
}

class CarAgency implements Rentable<Car>{
	@Override
	public Car rent() {
		return new Car();
	}
}

class GiftBox<T>{
	private T t;
	
	public T get() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
}

/*
 * 제한된 파라미터 처리
 * 특정 파라미터가 특정 타입의 하위 타입으로 제한 시킬때 주로 사용 
 * ex) public <T extends SuperType> 리턴 타입 메서드명(parameter)
 */


public class GenericEx { //데이터가 들어가는 시점에 타입을 결정
	
	//제너릭 메서드 구현 시 <T>type<T> 형태로 선언
	public static <T>GiftBox<T> boxing(T t){
		GiftBox<T> box = new GiftBox<T>();
		box.setT(t);
		return box;
	}
	
	//제한된 메서드 타입을 갖는 제네릭 메서드
	public static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + 
							t2.getClass().getSimpleName() + ")");
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return (v1 == v2);
	}
	
	public static void main(String[] args) {
		Box<String> box1 = new Box();
		box1.content = "Hello world";
		String str = box1.content;
		System.out.println(str);
		
		Box<Integer> box2 = new Box();
		box2.content = 100;
		int val = box2.content;
		System.out.println(val);

		///////////////////////////////////////////////////////
		Product<Tv, String> product1 = new Product();
		
		product1.setKind(new Tv());
		product1.setModel("smartTv");
		
		Tv tv = product1.getKind();
		String tvMode = product1.getModel();
		
		Product<Car, String> product2 = new Product();
		
		product2.setKind(new Car());
		product2.setModel("smartCar");
		
		Car car = product2.getKind();
		String CarMode = product2.getModel();
		
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car2 = carAgency.rent();
		car2.run();
		
		GiftBox<Integer> gbox1 = boxing(100);
		int value = gbox1.get();
		System.out.println(value);
		
		GiftBox<String> gbox2 = boxing("홍");
		String strvalue = gbox2.get();
		System.out.println(strvalue);
		
		boolean result1 = compare(10,20);
		System.out.println(result1);
		
		boolean result2 = compare(4.0,4);
		System.out.println(result2);
	}
}
