import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

public static void readFile(String file) throws FileNotFoundException {
	if(file == null)
		throw new NullPointerException();
	
	File f = new File(file);
	if(!f.exists()) {
		throw new FileNotFoundException();
	}
	
	System.out.println(file + " Yupp we found it!!!");
}
	
public static void main(String[] args) {
	
	Child ch = new Child();
	
	try {
		ch.test();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
//	String value = null;
//	System.out.println(value.charAt(0));
	
//	try {
//		readFile("/tmp/t.txt");
//	} catch (NullPointerException e) {
//		System.out.println("Null passed, please provide path properly");
//	} catch(FileNotFoundException e) {
//		System.out.println("File not found. please provide valid path");
//	} catch (Exception e) {
//		// TODO:
//	}
}
}
