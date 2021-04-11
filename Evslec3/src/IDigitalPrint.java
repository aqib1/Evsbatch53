
public interface IDigitalPrint extends IPrinter {
//	 void test();
	default void customPrint() {
		System.out.println("Digital Print");
	}
}
