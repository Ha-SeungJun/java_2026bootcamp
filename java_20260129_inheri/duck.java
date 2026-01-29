package java_20260129_inheri;

public class duck extends animal implements Fly{

	public String name;
	public String breed;
	
	public duck(String name, String breed){
		super("duck");
		this.name = name;
		this.breed = breed;
		}
	public String toString() { 
		return super.toString() + ", 이름은 " + name + ", 품종은 " + breed;
	}
	
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("꽤에엑");
	}
	
	public void layEggs() {
		System.out.println("알 낳기(오리)");
	}
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.printf("오리 %d속로도 날다 \n",birdVelocity.duck_velocity);
	}
}
