
public interface IDigitalPrint extends IPrinter {
 
	default void customPrint() {
		System.out.println("Digital Print");
	}
}
