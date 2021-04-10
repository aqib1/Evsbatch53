import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {
	
		// Anonymous inner types
//		IPrinter iprinter = new IPrinter() {
//			@Override
//			public void print() {
//				System.out.println("Hi");
//				
//			}
//		};
//		iprinter.print();
		
		// 1.7 dimand operator
		
		//10 -> int [] data = new int [10];
		// int [] newData = new int [10 + 5];
		List<List<Integer>> data = new ArrayList<>();
		data.add(Arrays.asList(1, 2, 3));
		data.add(Arrays.asList(4, 5, 6));
		data.add(Arrays.asList(7, 8, 9));
		
		
//		System.out.println(data);
		
		
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(2);
		set.add(1);
		
//		if(15 % 2 == 0) {
//			
//		}
		
		// () -> {}
		// (Integer i) -> {}
		set.stream().forEach(i -> System.out.println(i));
		
		
//		System.out.println(set);
		
//		MyPrinterApp my = new MyPrinterApp();
//		my.customPrint();
	}
}
