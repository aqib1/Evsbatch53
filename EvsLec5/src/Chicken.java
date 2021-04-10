
public class Chicken extends Animal {
	
	//Method overload -> Static polymorphisum
	// Run-time polymorphisum
	@Override
	public void feed() {
		System.out.println("Chicken feed");
	}
	
	public void feed(int quantity) {	
		System.out.println("Chicken feed ["+ quantity + "] grams");
	}
	
	public void feed(int quantity, String feedType) {
		System.out.println("Check ["+ feedType+"] ["+ quantity +"] grams");
	}
}
