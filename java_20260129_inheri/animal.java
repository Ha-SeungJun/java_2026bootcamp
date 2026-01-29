package java_20260129_inheri;

/*
 * 동물의 관련된 super클래스
 * 이 클래스는 type변수를 하나 선언, 하위 자식 객체가 밸생될때마다 어떤 종류의 동물인지를 
 * type을 통해 초기화 할 예정
 */




public abstract class animal {
	public String type;
	
	public animal(String type) {
		this.type = type;
	}

	//추상화 대상 : 메서드 기능은 상속, 내용은 자신 클래스의 필요 없음, abstract 라고 선언 
	//조건 : 메서드의 선언만 함, body 는 정의할 수 없음 / 추상 메서드를 하나 이상 가지고 있는 클래스는 무조건 추상 클래스로 선언 / 자식은 무조건 오버라이드해야함
	//		추상 클래스는 자신의 인스턴스 발생 못함, 단 상속은 가능하기에 super 타입으로서 객체 존재 가능 
	public abstract void sound();
	
	//개 고양이 오리 정의
	
	public String toString() {
		return "이것은 " + type;
	}
}
