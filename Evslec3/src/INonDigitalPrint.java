
public interface INonDigitalPrint extends IPrinter {

	default void customPrint() {
		System.out.println("INon digital");
	}
}
