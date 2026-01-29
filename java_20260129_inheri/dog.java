package java_20260129_inheri;

public class dog extends animal {

	public String name;
	public String breed;
	
	public dog(String name, String breed){
		super("dog");
		this.name = name;
		this.breed = breed;
		}
	public String toString() { 
		return super.toString() + ", 이름은 " + name + ", 품종은 " + breed;
	}
	
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("크르르릉");
	}
}
