import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {
	public static void main(String[] args) {
		File file = new File("tmp.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Byte stream - 1 byte (8 bits)
		// reader
		//try with resource
//		try(FileInputStream fileInputStream = new FileInputStream(file)) {
////			int byteInfo;
////			while((byteInfo = fileInputStream.read()) != -1) {
////				System.out.print((char) byteInfo);
////			}
//			
//			byte dataArray[] = new byte[(int) file.length()]; 
//			fileInputStream.read(dataArray);
//			System.out.println(new String(dataArray));
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		
		//writer
//		String data = "Hi there everyone!!!\n";
//		try(FileOutputStream outputStream = new FileOutputStream(file, true)) {
//			outputStream.write(data.getBytes());
//			outputStream.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		// Character stream - 1 character = 16 bit = 2 bytes
		// reader
//		try(FileReader fr = new FileReader(file)) {
//			char[] input = new char[(int) file.length()];
//			fr.read(input);
//			System.out.println(String.valueOf(input));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// writer 
//		String data = "Hi there everyone!!!\n";
//		try(FileWriter fw = new FileWriter(file, true)) {
//			fw.write(data.toCharArray());
//			fw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// Buffered -> buffering 
		// reader -> byte buffer or character buffer
		// buffered byte flavour
//		try(BufferedInputStream bis = new BufferedInputStream(
//				new FileInputStream(file))) {
//			byte [] read = new byte[(int) file.length()];
//			bis.read(read);
//			System.out.println(new String(read));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// buffered character flavour
//		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
//			char[] read = new char[(int) file.length()];
//			br.read(read);
//			System.out.println(String.valueOf(read));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// buffered writer 
		// byte flavour 

//		String data = "Hi there everyone!!!\n";
//		try(BufferedOutputStream bos = new BufferedOutputStream(
//				new FileOutputStream(file, true))) {
//			bos.write(data.getBytes());
//			bos.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// FileWiter
		String data = "Hi there everyone!!!\n";
		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(file, true))) {
			bw.write(data.toCharArray());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
