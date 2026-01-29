package java_20260129_inheri;

public class cat extends animal {

	public String name;
	public String breed;
	
	public cat(String name, String breed){
		super("cat");
		this.name = name;
		this.breed = breed;
		}
	public String toString() { 
		return super.toString() + ", 이름은 " + name + ", 품종은 " + breed;
	}
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("미냐아앙뇨오옹");
	}
}
