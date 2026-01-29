package java_20260129_inheri;

public class eagle extends animal implements Birdinter {
	public eagle(String type) {
		super("독수리");
	}
	
	int speed = eagle_velocity;

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("독수리 날다");
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("독수리 소리");
	}
	
	public int currentSpeed() {
		return Birdinter.getSpeed();
	}
}
