package java_20260129_inheri;

public interface Birdinter extends Fly, birdVelocity {
	default void birdfly() {System.out.printf("bird fly. speed : %d \n", eagle_velocity);}
	static int getSpeed() {return eagle_velocity;}
}
