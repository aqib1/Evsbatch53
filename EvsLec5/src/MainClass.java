
public class MainClass {
// Polymorphisum -> multiple, behaviour 
//	-- static/compile-time/early binding
//	-- dynamic/ run-time/late binding 
	public static void main(String[] args) {
		Animal animal = new Chicken(); // up-casting
		animal.feed();
		animal.test();
		
		
		Chicken c = (Chicken)animal;
		c.feed(12);
//		Chicken chicken =(Chicken)animal;
//		chicken.feed(12);
//		chicken.feed();
		
//		Animal animal = new Animal();
//		animal.feed();
//		Chicken chicken = new Chicken();
//		chicken.feed();
//		chicken.feed(55);
//		chicken.feed(55, "Noraml Feed");
	}
}
