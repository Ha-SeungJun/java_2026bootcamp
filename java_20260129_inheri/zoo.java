package java_20260129_inheri;

public class zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//animal animal = new animal("animal");
		//System.out.printf("이것은 %s \n",animal.type);
		
		animal dog = new dog("하랑","시츄");
		animal cat = new cat("하캣","톰");
		animal duck = new duck("하덕","제리");
	
		System.out.println(dog);
		System.out.println(cat);
		System.out.println(duck);
		
		System.out.println(dog); // 객체 호출시 toString 으로 호출함

		dog.sound();
		cat.sound();
		duck.sound();
		
		//다형성 : 상속관계에서 instance 를 발생시 super 타입으로 하위 instance 를 생성하는 형태
		//		 타입은 super 로 해당 인스턴스의 외형은 자식으로, 내부에는 부모 인스턴스가 생성
		//		 
		animal[] animals = {dog,cat,duck};
		for(animal animal : animals) {
			System.out.println(animal);
			animal.sound();
		}
		
		((duck)duck).layEggs();
		
		for(int i = 0; i < animals.length; i++) {
			animal ani = animals[(int)(Math.random() * animals.length)];
			System.out.println(ani);
			ani.sound();
			
			if(ani instanceof duck) {
				((duck)ani).layEggs();
				((duck)ani).fly();
			}
		}
		
		Object eagle1 = new eagle("독수리");
		animal eagle2 = new eagle("독수리");
		eagle eagle3 = new eagle("독수리");
		Fly eagle4 = new eagle("독수리");
		birdVelocity eagle5 = new eagle("독수리");
		
		//final : 고정 / 클래스 앞 선언시 상속금지, 메서드 앞 선언시 오버라이드 금지, 변수 앞 선언시 값변경 금지
		//static final 은 상수로 표현되는 의미
		
		//--------------------------------------------------------------------------------------
		//익명 구현 객체 > 특정 추상, 인터페이스의 하위 객체를 한 번만 만들어서 사용하고 버릴때 사용
		Birdinter bi = new Birdinter() {
			
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
